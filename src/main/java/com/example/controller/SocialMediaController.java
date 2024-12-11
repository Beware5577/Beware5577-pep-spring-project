package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;

import com.example.service.AccountService;
import com.example.service.MessageService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    private final AccountService accountService;
    private final MessageService messageService;


    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService)
    {
        this.accountService = accountService;
        this.messageService = messageService;
    }


    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<Account> postRegistrationHandler(@RequestBody Account account)
    {
        return ResponseEntity.ok(account);
    }


    @PostMapping(value = "/login")
    public @ResponseBody ResponseEntity<Account> postLoginHandler(@RequestBody Account account)
    {
        return ResponseEntity.ok(account);
    }


    @PostMapping(value = "/messages")
    public @ResponseBody ResponseEntity<Message> postMessagesHandler(@RequestBody Message message)
    {
        return ResponseEntity.ok(message);
    }


    @GetMapping("/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAllMessagesHandler()
    {
        List<Message> allMessages = new ArrayList();
        return ResponseEntity.ok(allMessages);
    }


    @GetMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> getMessageByIdHandler(@PathVariable int Id)
    {
        Message m = new Message();
        return ResponseEntity.ok(m);
    }


    @DeleteMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> deleteMessageByIdHandler(@PathVariable int Id)
    {
        Message m = new Message();
        return ResponseEntity.ok(m);
    }


    @PatchMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> patchMessageByIdHandler(@PathVariable int Id)
    {
        Message m = new Message();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/accounts/{account_id}/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAccountMessagesHandler(@PathVariable int Id)
    {
        List<Message> allMessages = new ArrayList();
        return ResponseEntity.ok(allMessages);
    }
}