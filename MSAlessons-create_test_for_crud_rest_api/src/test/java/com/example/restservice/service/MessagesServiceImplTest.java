package com.example.restservice.service;

import com.example.restservice.model.MessageFromMsa;
import com.example.restservice.repository.MessagesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MessagesServiceImplTest {

    @TestConfiguration
    static class MessagesServiceConfig {

        @Bean
        MessagesServiceImpl messagesService() {
            return  new MessagesServiceImpl();
        }
    }

    @Autowired
    private MessagesService messagesService;

    @MockBean
    private MessagesRepository repository;

    @Before
    public void setUp() {
        MessageFromMsa message = new MessageFromMsa();
        message.setMessage("First Message");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(message));
    }

    @Test
    public void getTest() {
        MessageFromMsa checkMessage = new MessageFromMsa();
        checkMessage.setMessage("First Message");

        MessageFromMsa found = messagesService.findById(1L);

        assertEquals(checkMessage.getMessage(),found.getMessage());
    }

}