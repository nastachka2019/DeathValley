package com.devIncubator.task.connection;

import com.devIncubator.task.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Class is used to store, give and receive back connections.
 *
 * @author Shpakova A.
 */
public enum ConnectionPool {
    INSTANCE;
    private BlockingQueue<ConnectionProxy> freeConnections;
    private Queue<ConnectionProxy> givenConnections;         // to control the integrity of the pool
    private final Logger logger = LogManager.getLogger();
    private Properties properties;
    private PropertyLoader propertyLoader;
    private final String PATH_CONFIG = "database.properties";
    private final static String URL = "url";
    private final int POOL_SIZE;

    ConnectionPool() {
        propertyLoader = new PropertyLoader();
        properties = propertyLoader.setProperty(PATH_CONFIG);
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            logger.fatal("Failed to register driver");
            throw new RuntimeException();
        }
        POOL_SIZE = Integer.parseInt(properties.getProperty("poolSize"));
        freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);           // fill queue with connections
        ConnectionProxy connectionProxy = null;
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                connectionProxy = new ConnectionProxy(DriverManager.getConnection(properties.getProperty(URL), properties));
                freeConnections.offer(connectionProxy);
            } catch (SQLException e) {
                logger.error("Error initializing connection pool", e);
            }
        }
        givenConnections = new ArrayDeque<>();
    }

    /**
     * Method: extract connection
     */
    public ConnectionProxy getConnection() {
        ConnectionProxy connection = null;
        try {
            connection = freeConnections.take();
            givenConnections.offer(connection);      //taken connection remove in the second queue
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Failed connection ", e);
        }
        return connection;
    }

    /**
     * Method: release connection
     */

    public void releaseConnection(Connection connection) throws ConnectionPoolException {   //free connection
        if (connection.getClass() == ConnectionProxy.class) {      // compare, we are returned to our connection (proxy) or "wild"
            givenConnections.remove(connection);
            freeConnections.offer((ConnectionProxy) connection);
        } else {
            throw new ConnectionPoolException();
        }
    }

    public int checkPoolSize() {
        return freeConnections.size() + givenConnections.size();
    }

    /**
     * Method: destroy connection pool
     */
    public void destroyPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                freeConnections.take().realClose();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Failed of close connections ", e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();     //get links to all drivers
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Exception in deregistration of drivers", e);
            }
        }
        logger.error("Finish deregistration of drivers");
    }
}
