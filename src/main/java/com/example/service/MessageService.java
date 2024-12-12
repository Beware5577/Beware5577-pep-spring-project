package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.MessageRepository;
import com.example.entity.Message;

import java.util.List;

public class MessageService {

    private MessageRepository messageRepository;

    /*
    * Constructor with provided repository
    * 
    * @param messageRepository
    */
    @Autowired
    public MessageService(MessageRepository messageRepository)
    {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<Message> createMessage(Message message)
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<List<Message>> getAllMessages()
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Message> getMessageById(int Id)
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Message> deleteMessageById(int Id)
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Message> patchMessageById(int Id)
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<List<Message>> getMessagesByAccountId(int Id)
    {
        return ResponseEntity.ok(null);
    }
}
