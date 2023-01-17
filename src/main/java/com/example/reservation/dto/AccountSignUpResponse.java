package com.example.reservation.dto;

import com.example.reservation.entity.Account;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AccountSignUpResponse {

    private String usrId;
    private String usrNm;
    private String usrType;

    private String token;

    public AccountSignUpResponse(Account acc, String token) {
        this.usrId = acc.getUsrId();
        this.usrNm = acc.getUsrNm();
        this.usrType = acc.getUsrType();
        this.token=token;
    }

}
