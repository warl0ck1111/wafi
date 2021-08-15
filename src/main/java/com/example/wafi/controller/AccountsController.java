package com.example.wafi.controller;/*
 * @author Okala III
 */

import com.example.wafi.dto.*;
import com.example.wafi.model.Account;
import com.example.wafi.model.Transaction;
import com.example.wafi.service.impl.AccountServiceImpl;
import com.example.wafi.service.impl.TransactionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountsController {

    private AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    private TransactionServiceImpl transactionServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountDTO dto){


        Account account = accountServiceImpl.createAccount(dto);
        return new ResponseEntity<>(new AccountResponse(200,true,String.format("Account Created Successfully. Your account number is $%s", account.getAccountNumber())), HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositDTO dto){

        Account account = accountServiceImpl.deposit(dto);
        return new ResponseEntity<>(new AccountResponse(200,true,String.format("Deposit Successful. New Account balance is $%s ", account.getBalance())), HttpStatus.OK);
    }


    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO dto){
        Account account = accountServiceImpl.withdraw(dto);
        return new ResponseEntity<>(new AccountResponse(200,true,String.format("Withdraw Successful, New Account Balance is $%s",account.getBalance())), HttpStatus.OK);
    }

    @PostMapping("/info")
    public ResponseEntity<?> accountInfo(@RequestBody RequestDto dto){
        Account account = accountServiceImpl.accountInfo(dto);
        return new ResponseEntity<>(new AccountInfoDTO(200,true,"See Object for details",account), HttpStatus.OK);

    }

    @PostMapping("/statement")
    public ResponseEntity<?> accountStatus(@RequestBody RequestDto dto){
        List<Transaction> transactionsList = transactionServiceImpl.findAll();
        return new ResponseEntity<>(transactionsList, HttpStatus.OK);
    }

}
