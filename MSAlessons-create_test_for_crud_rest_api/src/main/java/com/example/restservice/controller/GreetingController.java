package com.example.restservice.controller;


import com.example.restservice.model.MessageFromMsa;
import com.example.restservice.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class GreetingController {


    @Autowired
    private MessagesService messagesService;

    @GetMapping
    public List<MessageFromMsa> allMessages() {
        return messagesService.findAll();
    }

    @GetMapping("{id}")
    public MessageFromMsa getOneMessageFromId(@PathVariable String id) {
              return messagesService.findById(Long.parseLong(id));

    }

    @PostMapping
    public MessageFromMsa createMessage(@RequestBody MessageFromMsa newMessage) {
        return  messagesService.createMessage(newMessage);
    }

    @PutMapping("{id}")
    public MessageFromMsa updateMessage(@PathVariable String id) {
        return messagesService.updateMessage(messagesService.findById(Long.parseLong(id)));
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id) {
        messagesService.deleteMessageById(Long.parseLong(id));
    }

}
