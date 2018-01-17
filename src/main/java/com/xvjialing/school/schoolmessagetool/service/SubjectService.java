package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.Subject;
import com.xvjialing.school.schoolmessagetool.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjectList(){
        return subjectRepository.findAll();
    }

    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }

}