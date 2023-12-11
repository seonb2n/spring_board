package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;
import com.example.springboard.util.enums.AUTHTYPE;
import com.example.springboard.util.enums.GENDER;
import java.time.LocalDate;

public class User extends BaseEntity {

    private int id;
    private String userName;
    private String accountId;
    private String accountPassword;
    private AUTHTYPE authtype;
    private String realName;
    private LocalDate birthDate;
    private GENDER gender;
    private String phoneNumber;

    private User(int id, String userName, String accountId, String accountPassword,
        AUTHTYPE authtype,
        String realName, LocalDate birthDate, GENDER gender, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.authtype = authtype;
        this.realName = realName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    static User of(int id, String userName, String accountId, String accountPassword,
        AUTHTYPE authtype, String realName, LocalDate birthDate, GENDER gender,
        String phoneNumber) {
        return new User(id, userName, accountId, accountPassword, authtype, realName, birthDate,
            gender, phoneNumber);
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public AUTHTYPE getAuthtype() {
        return authtype;
    }

    public String getRealName() {
        return realName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
