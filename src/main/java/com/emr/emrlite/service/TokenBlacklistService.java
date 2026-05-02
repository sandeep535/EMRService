package com.emr.emrlite.service;

import com.emr.emrlite.model.InvalidatedTokenModel;
import com.emr.emrlite.repository.InvalidatedTokenRepository;
import com.emr.emrlite.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenBlacklistService {

    @Autowired
    private InvalidatedTokenRepository invalidatedTokenRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public void blacklist(String token, String username) {
        InvalidatedTokenModel model = new InvalidatedTokenModel();
        model.setToken(token);
        model.setUsername(username);
        model.setExpiry(jwtUtil.extractExpiration(token));
        model.setLogoutTime(new Date());
        invalidatedTokenRepository.save(model);
    }

    public boolean isBlacklisted(String token) {
        return invalidatedTokenRepository.existsByToken(token);
    }
}
