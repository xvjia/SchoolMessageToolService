package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.Message;
import com.xvjialing.school.schoolmessagetool.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message addMessage(Message message){
        return messageRepository.save(message);
    }
}