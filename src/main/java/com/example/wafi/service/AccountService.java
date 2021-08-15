package com.example.wafi.service;

import com.example.wafi.dto.CreateAccountDTO;
import com.example.wafi.dto.DepositDTO;
import com.example.wafi.dto.RequestDto;
import com.example.wafi.dto.WithdrawDTO;
import com.example.wafi.model.Account;

public interface AccountService {
    Account createAccount(CreateAccountDTO dto);

    Account deposit(DepositDTO dto);

    Account withdraw(WithdrawDTO dto);

    Account accountInfo(RequestDto dto);

    boolean canWithdraw(String accountNumber, double amount);
}
