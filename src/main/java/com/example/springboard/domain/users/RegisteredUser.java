package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class RegisteredUser extends BaseEntity {

    private Integer id;
    private String accountId;
    private String accountPassword;
    private String realName;
    private String birthDate;
    private String mobileNo;

    public RegisteredUser(Integer id, String accountId, String accountPassword, String realName,
        String birthDate, String mobileNo) {
        this.id = id;
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.realName = realName;
        this.birthDate = birthDate;
        this.mobileNo = mobileNo;
    }

    public static RegisteredUser of(Integer realUserId, String accountId, String accountPassword,
        String realName,
        String birthDate, String mobileNo) {
        return new RegisteredUser(realUserId, accountId, accountPassword, realName, birthDate,
            mobileNo);
    }

    public Integer getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public String getRealName() {
        return realName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
