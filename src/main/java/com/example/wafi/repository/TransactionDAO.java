package com.example.wafi.repository;/*
 * @author Okala III
 */

import com.example.wafi.model.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class TransactionDAO {

    public static HashMap<Integer, Transaction> transactions = new HashMap<>();

    public static boolean save(Transaction transaction){
        transactions.put(transactions.size()+1,transaction);
        return true;
    }

    public static List<Transaction> findAll(){
        List<Transaction> allTransactions = new ArrayList<>();
        for(Integer key : transactions.keySet()){
            Transaction transaction = TransactionDAO.transactions.get(key);
            allTransactions.add(transaction);
        }
        return allTransactions;
    }
}
