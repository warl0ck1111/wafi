package com.example.wafi.dto;

import lombok.Data;

@Data
public class WithdrawDTO {

    private String accountNumber;
    private String accountPassword;
    private Double withdrawnAmount;
}
