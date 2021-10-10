package com.example.restservice.controller;


import com.example.restservice.model.Messages;
import com.example.restservice.service.MessagesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class GreetingController {


    @Autowired
    private MessagesServiceImpl messagesService;

    @GetMapping
    public List<Messages> allMessages() {
        return messagesService.findAll();
    }

    @GetMapping("{id}")
    public Messages getOneMessageFromId(@PathVariable String id) {
              return messagesService.findById(Long.parseLong(id));

    }

    @PostMapping
    public Messages createMessage(@ModelAttribute Messages newMessage) {
        return  messagesService.createMessage(newMessage);
    }

    @PutMapping("{id}")
    public Messages updateMessage(@ModelAttribute Messages newMessage) {
        return messagesService.updateMessage(newMessage);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id) {
        messagesService.deleteMessageById(Long.parseLong(id));
    }

}
