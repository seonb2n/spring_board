package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;

public class RegisteredUser extends BaseEntity {

    private Integer id;
    private Integer realUserId;
    private Integer accountId;
    private String realName;
    private String birthDate;
    private String mobileNo;

    private RegisteredUser(Integer realUserId, Integer accountId, String realName, String birthDate,
        String mobileNo) {
        this.realUserId = realUserId;
        this.accountId = accountId;
        this.realName = realName;
        this.birthDate = birthDate;
        this.mobileNo = mobileNo;
    }

    public static RegisteredUser of(Integer realUserId, Integer accountId, String realName,
        String birthDate, String mobileNo) {
        return new RegisteredUser(realUserId, accountId, realName, birthDate, mobileNo);
    }

    public Integer getId() {
        return id;
    }

    public Integer getRealUserId() {
        return realUserId;
    }

    public Integer getAccountId() {
        return accountId;
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
