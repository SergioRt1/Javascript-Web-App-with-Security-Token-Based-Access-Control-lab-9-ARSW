package com.example.lab9.services;

import com.example.lab9.model.Message;

import java.util.List;

public interface MessagesServices {

    List<Message> getLastMessages() throws MessageException;

    void saveMessage(Message message) throws MessageException;
}
