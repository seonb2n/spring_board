package com.example.springboard.repository;

import com.example.springboard.domain.users.RegisteredUser;
import com.example.springboard.domain.users.User;
import com.example.springboard.mapper.RegisteredUserMapper;
import com.example.springboard.mapper.UserMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final RegisteredUserMapper registeredUserMapper;
    private final UserMapper userMapper;

    public UserRepository(RegisteredUserMapper registeredUserMapper, UserMapper userMapper) {
        this.registeredUserMapper = registeredUserMapper;
        this.userMapper = userMapper;
    }

    public Optional<User> findUserByNickName(String nickname) {
        return Optional.of(userMapper.findUserByNickName(nickname));
    }

    public Optional<RegisteredUser> findRegisteredUserByAccountId(String accountId) {
        return Optional.ofNullable(registeredUserMapper.findUserByAccountId(accountId));
    }

    public Optional<User> findUserByUserId(int userId) {
        return Optional.ofNullable(userMapper.findUserByUserId(userId));
    }

    public int createUser(User user) {
        return userMapper.createUser(user);
    }
}
