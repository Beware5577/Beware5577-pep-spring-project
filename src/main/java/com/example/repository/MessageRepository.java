package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    /**
     * Finds a message by the account it was posted by.
     * 
     * @param postedBy
     * 
     * @return List of messages made by account.
     */
    List<Message> findByPostedBy(int postedBy);


    /**
     * Finds message by id
     * 
     * @param messageId
     * 
     * @return Message with given id.
     */
    Message findByMessageId(int messageId);
}
