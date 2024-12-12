package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;
import com.example.entity.Account;

public class AccountService {

    private AccountRepository accountRepository;

    /*
    * Constructor with provided repository
    * 
    * @param accountRepository
    */
    @Autowired
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }


    /*
    * Registers new accounts.
    * 
    * @param account
    *
    * @return Returns a response entity with a status code and account
    *         or null in the body.
    */
    public ResponseEntity<Account> registerAccount(Account account)
    {
        //Getting status code to determine if account has valid parameters
        HttpStatus checkStatus = accountRepository.validAccountParameters(account.getUsername(), account.getPassword());

        //Checking status code and returning if bad status
        if(checkStatus == HttpStatus.BAD_REQUEST || checkStatus == HttpStatus.CONFLICT)
            return ResponseEntity.status(checkStatus).body(null);

        //Registering account and returning a response entity
        return accountRepository.registerAccount(account);

    }


    /*
    * Logs into existing accounts.
    * 
    * @param account
    *
    * @return Returns a response entity with a status code and account
    *         or null in the body.
    */
    public ResponseEntity<Account> logInAccount(Account account)
    {
        //Attempting to log into account and returning results
        return accountRepository.logInAccount(account.getUsername(), account.getPassword());
    }

}
