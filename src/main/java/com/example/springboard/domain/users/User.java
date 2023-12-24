package com.example.springboard.domain.users;

import com.example.springboard.domain.BaseEntity;
import com.example.springboard.util.enums.AuthType;
import com.example.springboard.util.enums.Gender;
import java.time.LocalDate;

public class User extends BaseEntity {

    private int id;
    private String userName;
    private String accountId;
    private String accountPassword;
    private AuthType authtype;
    private String realName;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;

    private User(int id, String userName, String accountId, String accountPassword,
        AuthType authtype,
        String realName, LocalDate birthDate, Gender gender, String phoneNumber) {
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
        AuthType authtype, String realName, LocalDate birthDate, Gender gender,
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

    public AuthType getAuthtype() {
        return authtype;
    }

    public String getRealName() {
        return realName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
