package com.example.reservation.service;

import com.example.reservation.dto.AccountSignUpRequest;
import com.example.reservation.dto.AccountSignUpResponse;
import com.example.reservation.entity.Account;
import com.example.reservation.jwt.JwtTokenProvider;
import com.example.reservation.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository lr;
    private final JwtTokenProvider jwtTokenProvider;

    public AccountSignUpResponse login(AccountSignUpRequest req) {
        Account acc = req.toEntity();
        Account result = lr.findById(acc.getUsrId()).orElse(null);
        if (result != null) {

            String token=jwtTokenProvider.makeJwtToken(req);

            return new AccountSignUpResponse(result,token);
        } else {
            return null;
        }
    }

}
