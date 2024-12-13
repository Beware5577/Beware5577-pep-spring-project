package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

    /**
     * Finds an account by an account username.
     * 
     * @param username
     * 
     * @return Account with given username.
     */
    @Query("FROM Account WHERE username = :varUsername")
    Account findByUsername(@Param("varUsername") String username);


    /**
     * Finds an account by an account username and password.
     * 
     * @param username
     * @param password
     * 
     * @return Account with given username and password.
     */
    @Query("FROM Account WHERE username = :varUsername AND password = :varPassword")
    Account findByUsernameAndPassword(@Param("varUsername") String username, @Param("VarPassword") String password);

}
