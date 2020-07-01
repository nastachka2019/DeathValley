package com.devIncubator.task.entity;


import javax.persistence.criteria.CriteriaBuilder;

/**
 * Class for storing user's data
 *
 * @author Shpakova A.
 */

public class User extends Entity {
    private Integer userId;
    private String name;
    private String surname;

    public User() {
    }

    public User(Integer userId, String name, String surname) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) object;
        return userId == user.userId &&
                (name == user.name || (name != null && name.equals(user.getName()))) &&
                (surname == user.surname || (surname != null && surname.equals(user.getSurname())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + userId;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static class Builder {
        private Integer userId;
        private String name;
        private String surname;

        public Builder(Integer userId, String name, String surname) {
            this.userId = userId;
            this.name = name;
            this.surname = surname;
        }

        public User build() {
            return new User(this) {
            };
        }
    }

    private User(Builder builder) {
        userId = builder.userId;
        name = builder.name;
        surname = builder.surname;
    }
}
