package com.devIncubator.task.entity;

import java.util.Objects;

/**
 * Class for storing account's data
 *
 * @author Shpakova A.
 */

public class Account extends Entity {
    private Integer accountId;
    private Integer accountUser;
    private User userId;

    public Account() {
    }

    public Account(Integer accountId, Integer accountUser, User userId) {
        this.accountId = accountId;
        this.accountUser = accountUser;
        this.userId = userId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(Integer accountUser) {
        this.accountUser = accountUser;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Account account = (Account) object;
        return accountId == account.accountId &&
                accountUser == account.accountUser &&
                (userId == account.userId || (userId != null && userId.equals(account.getUserId())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accountId;
        result = prime * result + accountUser;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountUser=" + accountUser +
                ", userId=" + userId +
                '}';
    }

    public static class Builder {
        private Integer accountId;
        private Integer accountUser;
        private User userId;

        public Builder(Integer accountId, Integer accountUser, User userId) {
            this.accountId = accountId;
            this.accountUser = accountUser;
            this.userId = userId;
        }

        public Account build() {
            return new Account(this) {
            };
        }
    }

    private Account(Builder builder) {
        accountId = builder.accountId;
        accountUser = builder.accountUser;
        userId = builder.userId;
    }
}
