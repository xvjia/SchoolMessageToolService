package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.Message;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.repository.ClassRepository;
import com.xvjialing.school.schoolmessagetool.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ClassRepository classRepository;

    public Message addMessage(Message message){
        return messageRepository.save(message);
    }

//    public List<Message> getOneClassMessage(SchoolClass schoolClass){
//        return messageRepository.findAllBySchoolClass(schoolClass);
//    }

    public List<Message> getMessageList(){
        return messageRepository.findAll();
    }

    @Transactional
    public List<Message> findByClass(Integer classId,Integer messageType){
        SchoolClass schoolClass=classRepository.findOne(classId);
        if (schoolClass==null){
            return null;
        }
        return messageRepository.findAllBySchoolClassAndAndMessageType(schoolClass,messageType);
    }
}