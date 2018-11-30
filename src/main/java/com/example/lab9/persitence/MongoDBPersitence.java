package com.example.lab9.persitence;

import com.example.lab9.model.Message;
import com.example.lab9.repository.MessageRepository;
import com.example.lab9.services.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBPersitence implements MessagesPersitence{

    @Autowired
    MessageRepository messages;


    @Override
    public List<Message> getLastMessages() throws MessageException {
        List<Message> message = messages.findAll(new Sort(Sort.Direction.DESC, "date"));
        return message.subList(0,Math.min(10,message.size()));
    }

    @Override
    public void saveMessage(Message message) throws MessageException {
        messages.save(message);
    }
}
