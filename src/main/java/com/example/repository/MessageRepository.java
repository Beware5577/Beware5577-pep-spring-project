package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer>{

    /**
     * Finds a message by the account it was posted by.
     * 
     * @param postedBy
     * 
     * @return List of messages made by account.
     */
    @Query("FROM Message WHERE postedBy = :varPostedBy")
    List<Message> findByPostedBy(@Param("varPostedBy") int postedBy);


    /**
     * Finds a message without the message id.
     * 
     * @param messageText
     * @param postedBy
     * @param timePostedEpoch
     * 
     * @return Found message with id.
     */
    @Query("FROM Message WHERE messageText = :varMessageText AND postedBy = :varPostedBy AND timePostedEpoch = :varTimePostedEpoch")
    Message findWithoutId(@Param("varMessageText") String messageText, @Param("varPostedBy") int postedBy, @Param("varTimePostedEpoch") Long timePostedEpoch);
}
