package com.example.restservice.service;

import com.example.restservice.model.MessageFromMsa;
import com.example.restservice.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public List<MessageFromMsa> findAll() {
        return messagesRepository.findAll();
    }

    @Override
    public MessageFromMsa findById(Long id) {
        Optional<MessageFromMsa> findMessage = messagesRepository.findById(id);
        return findMessage.get();
    }

    @Override
    public MessageFromMsa createMessage(MessageFromMsa messages) {
        return messagesRepository.save(messages);
    }


    @Override
    public void deleteMessageById(Long id) {
        messagesRepository.deleteById(id);
    }

    @Override
    public MessageFromMsa updateMessage(MessageFromMsa messages) {
        Optional<MessageFromMsa> updateMes = messagesRepository.findById(messages.getId());
        return messagesRepository.save(updateMes.get());
    }
}
