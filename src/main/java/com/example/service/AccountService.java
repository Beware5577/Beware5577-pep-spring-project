package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;
import com.example.entity.Account;

@Service
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
        //Checking if account is valid to register
        if(account.getUsername().equals("") == true || account.getPassword().equals("") == true || account.getUsername().length() < 4)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        //Checking if duplicate account exists
        if(accountRepository.findByUsername(account.getUsername()) != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        
        //Persisting account to database
        accountRepository.save(account);

        //Getting account to return with id
        return ResponseEntity.ok(accountRepository.findByUsername(account.getUsername()));
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
        //Getting account to check
        Account loggedAccount = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());

        //Checking if account matches username and password
        if(loggedAccount == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        //Account exists so returning account
        return ResponseEntity.ok(loggedAccount);    
    }

}
