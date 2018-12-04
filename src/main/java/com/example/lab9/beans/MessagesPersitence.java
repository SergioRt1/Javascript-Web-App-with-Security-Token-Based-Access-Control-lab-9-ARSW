package com.example.lab9.beans;

import com.example.lab9.model.Message;
import com.example.lab9.services.MessageException;

import java.util.List;

public interface MessagesPersitence {

    List<Message> getLastMessages() throws MessageException;

    void saveMessage(Message message) throws MessageException;
}
