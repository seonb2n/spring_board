package com.example.springboard.mapper;

import com.example.springboard.domain.users.User;

public interface UserMapper {

    User findUserByNickName(String nickname);

    User findUserByRegisteredUserId(Integer registeredUserId);
}
