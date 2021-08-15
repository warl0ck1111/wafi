package com.example.wafi.repository;/*
 * @author Okala III
 */

import com.example.wafi.model.Account;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
public class AccountDAO {

    public static HashMap<String, Account> accounts = new HashMap<>();

    public static Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    public static boolean accountExists(String account){
        return accounts.containsKey(account);
    }


    public static boolean save(Account account) {
        accounts.put(account.getAccountNumber(), account);
            log.debug("Account Record Saved");
        return true;
    }

    public static boolean nameExists(String accountName){
        boolean nameExists = false;
        for (String key : accounts.keySet()){
            if(accounts.get(key).getAccountName().equalsIgnoreCase(accountName)){
                nameExists = true;
                break;
            }
        }
        return nameExists;
    }

}
