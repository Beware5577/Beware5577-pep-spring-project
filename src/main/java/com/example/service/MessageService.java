package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.MessageRepository;
import com.example.repository.AccountRepository;
import com.example.entity.Message;

import java.util.List;

@Service
public class MessageService {

   private MessageRepository messageRepository;
   private AccountRepository accountRepository;

    /*
    * Constructor with provided repositories
    * 
    * @param messageRepository
    * @param accountRepository
    */
    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository)
    {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }


    /*
    * Creates new messages.
    * 
    * @param message
    *
    * @return Returns a response entity with a status code and message
    *         or null in the body.
    */
    public ResponseEntity<Message> createMessage(Message message)
    {
        //Checking if message can be created
        if(message.getMessageText().equals("") == true || message.getMessageText().length() > 255 || accountRepository.findByAccountId(message.getPostedBy()) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        //Returning created message with id
        return ResponseEntity.ok(messageRepository.save(message));
    }


    /*
    * Returns a list of all existing messages.
    * 
    * @return Returns a response entity with a status code and message
    *         list in the body.
    */
    public ResponseEntity<List<Message>> getAllMessages()
    {
        return ResponseEntity.ok(messageRepository.findAll());
    }


    /*
    * Returns a message with a certain ID if it exists.
    * 
    * @param messageId
    *
    * @return Returns a response entity with a status code and message
    *         in the body.
    */
    public ResponseEntity<Message> getMessageById(int messageId)
    {
        return ResponseEntity.ok(messageRepository.findByMessageId(messageId));
    }


    /*
    * Deletes a message with a certain ID if it exists.
    * 
    * @param messageId
    *
    * @return Returns a response entity with a status code and number
    *         of rows changed in the body.
    */
    public ResponseEntity<Integer> deleteMessageById(int messageId)
    {
        //Checking if message exists to delete
        if(messageRepository.findByMessageId(messageId) != null)
        {
            //Deleting message
            messageRepository.deleteById(messageId);

            //Message was deleted 1 row changed
            return ResponseEntity.ok(1);
        }

            //No message deleted no row change
            return ResponseEntity.ok(null);
    }


    /*
    * Finds if message with the provided ID exists.
    * If it does exist, it patches the message with
    * the provided updateText.
    * 
    * @param messageId
    * @param messageText
    *
    * @return Returns a response entity with a status code and number
    *         of rows changed in the body. 
    */
    public ResponseEntity<Integer> patchMessageById(int messageId, String messageText)
    {
        //Checking if message text is viable
        if(messageText.equals("") == true || messageText.length() > 255)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        //Checking if message exists
        Message updatedMessage = messageRepository.findByMessageId(messageId);
        if(updatedMessage == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        //Updating message
        updatedMessage.setMessageText(messageText);
        messageRepository.save(updatedMessage);

        return ResponseEntity.ok(1);

    }


    /*
    * Returns all messages associated with an account ID.
    * 
    * @param accountId
    *
    * @return Returns a response entity with a status code and message
    *         list in the body. 
    */
    public ResponseEntity<List<Message>> getMessagesByAccountId(int postedBy)
    {
        return ResponseEntity.ok(messageRepository.findByPostedBy(postedBy));
    }
}
