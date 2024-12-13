package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

    /**
     * Finds an account by an account username.
     * 
     * @param username
     * 
     * @return Account with given username.
     */
    Account findByUsername(String username);


    /**
     * Finds an account by an account username and password.
     * 
     * @param username
     * @param password
     * 
     * @return Account with given username and password.
     */
    Account findByUsernameAndPassword(String username, String password);


    /**
     * Finds an account with given id
     * 
     * @param accountId
     * 
     * @return Account with given id.
     */
    Account findByAccountId(int accountId);
}
