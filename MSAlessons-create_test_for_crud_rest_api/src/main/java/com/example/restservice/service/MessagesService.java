package com.example.restservice.service;

import com.example.restservice.model.MessageFromMsa;

import java.util.List;

public interface MessagesService {

    List<MessageFromMsa> findAll();

    MessageFromMsa findById(Long id);

    MessageFromMsa createMessage(MessageFromMsa messageFromMsa);

    void deleteMessageById(Long id);

    MessageFromMsa updateMessage(MessageFromMsa messageFromMsa);
}
