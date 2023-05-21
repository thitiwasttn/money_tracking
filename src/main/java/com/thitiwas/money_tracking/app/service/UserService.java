package com.thitiwas.money_tracking.app.service;

import com.thitiwas.money_tracking.app.entity.member.UserEntity;
import com.thitiwas.money_tracking.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    private final StringUtil stringUtil;

    @Autowired
    public UserService(UserRepository userRepository, StringUtil stringUtil) {
        this.userRepository = userRepository;
        this.stringUtil = stringUtil;
    }

    public Optional<UserEntity> findByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException {
        return userRepository.findByEmailAndPassword(email, password).stream().findAny();
    }

}
