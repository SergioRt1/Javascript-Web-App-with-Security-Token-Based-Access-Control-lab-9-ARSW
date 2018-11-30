package com.example.lab9.controller;

import com.example.lab9.model.Message;
import com.example.lab9.services.MessageException;
import com.example.lab9.services.MessagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    MessagesServices service;

    @GetMapping
    public ResponseEntity<?> getEventsHandler() {
        try {
            return new ResponseEntity<>(service.getLastMessages(), HttpStatus.ACCEPTED);
        } catch (MessageException ex) {
            Logger.getLogger(MessageException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> postSaveMessageHandler(@RequestBody Message message) {
        try {
            message.setTime(new Timestamp(System.currentTimeMillis()));
            service.saveMessage(message);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (MessageException ex) {
            Logger.getLogger(MessageException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

}
