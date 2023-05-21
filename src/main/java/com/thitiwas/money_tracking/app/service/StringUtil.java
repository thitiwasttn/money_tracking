package com.thitiwas.money_tracking.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class StringUtil {

    @Value("${custom.user.password.salt}")
    private String salt;

    private String encodeMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest m;
        m = MessageDigest.getInstance("MD5");
        m.update(str.getBytes(), 0, str.length());
        // System.out
        // .println("MD5: " + new BigInteger(1, m.digest()).toString(16));
        return new BigInteger(1, m.digest()).toString(16);
    }

    public String encodePassword(String password) throws NoSuchAlgorithmException {
        final String finalPassword = password.concat(salt);
        return encodeMD5(finalPassword);
    }
}
