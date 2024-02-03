package com.example.springboard.service;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.domain.users.RegisteredUser;
import com.example.springboard.domain.users.User;
import com.example.springboard.repository.UserRepository;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * accountId 와 accountPassword 에 따른 로그인 결과를 반환한다.
     *
     * @param accountId
     * @param accountPassword
     * @return
     */
    public boolean isValidUserLogin(String accountId, String accountPassword) {
        RegisteredUser user = userRepository.findRegisteredUserByAccountId(accountId)
            .orElseThrow(() -> new GlobalException(
                Map.of("accountId", accountId, "accountPassword", accountPassword),
                ErrorTypeWithRequest.LOGIN_ID_WRONG));
        return user.getAccountPassword().equals(accountPassword);
    }

    /**
     * 비가입 사용자에 대해서 닉네임과 비밀번호가 맞는지 검증한다.
     * @param nickname
     * @param password
     * @return
     */
    public boolean isValidUserNickname(String nickname, String password) {
        User user = userRepository.findUserByNickName(nickname)
            .orElseThrow(
                () -> new GlobalException(Map.of("nickname", nickname, "password", password),
                    ErrorTypeWithRequest.USER_NOT_FOUND_BY_NICKNAME));
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
            .orElseThrow(() -> new GlobalException(Map.of("accountId", accountId),
                ErrorTypeWithRequest.LOGIN_ID_WRONG));
        return user.getId();
    }

    /**
     * userId 로 User 를 가져온다.
     *
     * @param userId
     * @return
     */
    public User getUserBytUserId(int userId) {
        return userRepository.findUserByUserId(userId).orElseThrow(
            () -> new GlobalException(Map.of("userId", userId),
                ErrorTypeWithRequest.USER_NOT_FOUND_BY_ID));
    }

    public int createUser(String nickName, String password) {
        User user = User.of(nickName, password, false);
        return userRepository.createUser(user);
    }
}
