package com.devIncubator.task.exception;

/**
 * This class uses when exception is happen in Dao classes
 *
 * @author Shpakova A.
 */

public class DaoException extends Exception {
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
