package com.example.springboard.service;

import com.example.springboard.common.exception.user.UserNotFoundByAccountIdException;
import com.example.springboard.common.exception.user.UserNotFoundByNicknameException;
import com.example.springboard.domain.users.RegisteredUser;
import com.example.springboard.domain.users.User;
import com.example.springboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValidUserLogin(String accountId, String accountPassword) {
        RegisteredUser user = userRepository.findRegisteredUserByAccountId(accountId)
            .orElseThrow(UserNotFoundByAccountIdException::new);
        return user.getAccountPassword().equals(accountPassword);
    }

    public boolean isValidUserNickname(String nickname, String password) {
        User user = userRepository.findUserByNickName(nickname).orElseThrow(
            UserNotFoundByNicknameException::new);
        return user.getPassword().equals(password);
    }
}
