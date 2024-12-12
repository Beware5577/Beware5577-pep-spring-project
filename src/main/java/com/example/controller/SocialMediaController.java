package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;

import com.example.service.AccountService;
import com.example.service.MessageService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import java.util.ArrayList;
import java.util.List;

//import javax.websocket.server.PathParam;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@Controller
public class SocialMediaController {

    private final AccountService accountService;
    private final MessageService messageService;


    /*
     * Constructor
     */
    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService)
    {
        this.accountService = accountService;
        this.messageService = messageService;
    }


    /**
     * Handler to post a new registration.
     * 
     * @param account converted json representation of an account to be registered
     * 
     * @return A response entity containing the registered account and status code
     */
    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<Account> postRegistrationHandler(@RequestBody Account account)
    {
        //Will return with status code and registered account
        return accountService.registerAccount(account);
    }


    /**
     * Handler to post a login attempt.
     * 
     * @param account converted json representation of an account to be logged in
     * 
     * @return A response entity containing the logged in account and status code
     */
    @PostMapping(value = "/login")
    public @ResponseBody ResponseEntity<Account> postLoginHandler(@RequestBody Account account)
    {
        //Will return with status code and logged in account
        return accountService.logInAccount(account);
    }


    /**
     * Handler to post a new message.
     * 
     * @param message converted json representation of a message to be created
     * 
     * @return A response entity containing the created message and status code
     */
    @PostMapping(value = "/messages")
    public @ResponseBody ResponseEntity<Message> postMessagesHandler(@RequestBody Message message)
    {
        //Will return with status code and created message
        return messageService.createMessage(message);
    }


    /**
     * Handler to get all messages.
     * 
     * @return A response entity containing a list of messages and a status code
     */
    @GetMapping("/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAllMessagesHandler()
    {
        //Will return with status code and all messages
        return messageService.getAllMessages();
    }


    /**
     * Handler to get a message by id.
     * 
     * @param Id An integer id for a message
     * 
     * @return A response entity containing all messages and a status code
     */
    @GetMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> getMessageByIdHandler(@PathVariable int Id)
    {
        //Will return with status code and a message
        return messageService.getMessageById(Id);
    }


    /**
     * Handler to delete a message by id.
     * 
     * @param Id An integer id for a message
     * 
     * @return A response entity containing a deleted message and a status code
     */
    @DeleteMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> deleteMessageByIdHandler(@PathVariable int Id)
    {
        //Will return with status code and a deleted message
        return messageService.deleteMessageById(Id);
    }


    /**
     * Handler to patch a message by id.
     * 
     * @param Id An integer id for a message
     * 
     * @return A response entity containing an updated message and a status code
     */
    @PatchMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> patchMessageByIdHandler(@PathVariable int Id)
    {
        //Will return with status code and an updated message
        return messageService.patchMessageById(Id);
    }


    /**
     * Handler to get all messages from an account.
     * 
     * @param Id An integer id for an account
     * 
     * @return A response entity containing a list of account messages and a status code
     */
    @GetMapping("/accounts/{account_id}/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAccountMessagesHandler(@PathVariable int Id)
    {
        //Will return with status code and a message list
        return messageService.getMessagesByAccountId(Id);
    }
}