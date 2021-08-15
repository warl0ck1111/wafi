package com.example.wafi.service;

import com.example.wafi.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
}
