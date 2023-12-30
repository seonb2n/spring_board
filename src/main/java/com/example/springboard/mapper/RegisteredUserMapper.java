package com.example.springboard.mapper;

import com.example.springboard.domain.users.RegisteredUser;

public interface RegisteredUserMapper {

    RegisteredUser findUserByAccountId(String accountId);

}
