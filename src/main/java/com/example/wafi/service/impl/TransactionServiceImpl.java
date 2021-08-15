package com.example.wafi.service.impl;


import com.example.wafi.model.Transaction;
import com.example.wafi.repository.TransactionDAO;
import com.example.wafi.service.TransactionService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> findAll(){
        return TransactionDAO.findAll();
    }
}
