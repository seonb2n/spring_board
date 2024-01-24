package com.example.springboard.service;

import com.example.springboard.common.exception.user.UserNotFoundByAccountIdException;
import com.example.springboard.common.exception.user.UserNotFoundByNicknameException;
import com.example.springboard.common.exception.user.UserNotFoundByUserIdException;
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

    /**
     * accountId 로 userId 를 가져온다.
     *
     * @param accountId
     * @return
     */
    public int getUserIdByAccountId(String accountId) {
        RegisteredUser user = userRepository.findRegisteredUserByAccountId(accountId)
            .orElseThrow(UserNotFoundByAccountIdException::new);
        return user.getId();
    }

    /**
     * userId 로 User 를 가져온다.
     *
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId) {
        return userRepository.findUserByUserId(userId).orElseThrow(
            UserNotFoundByUserIdException::new);
    }

    public int createUser(String nickName, String password) {
        User user = User.of(nickName, password, false);
        return userRepository.createUser(user);
    }
}
