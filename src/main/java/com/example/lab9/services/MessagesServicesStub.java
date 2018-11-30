package com.example.lab9.services;

import com.example.lab9.model.Message;
import com.example.lab9.persitence.MessagesPersitence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServicesStub implements MessagesServices{

    @Autowired
    MessagesPersitence persitence;


    @Override
    public List<Message> getLastMessages() throws MessageException{
        return persitence.getLastMessages();
    }

    @Override
    public void saveMessage(Message message) throws MessageException {
        persitence.saveMessage(message);
    }
}
