package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepository;

    public SchoolClass addClass(SchoolClass schoolClass){
        return classRepository.save(schoolClass);
    }

    public boolean existsByClassNumber(String classNumber){
        return classRepository.existsByClassNumber(classNumber);
    }

    public List<SchoolClass> getClassList(){
        return classRepository.findAll();
    }

    public SchoolClass findOneClass(Integer id){
        return classRepository.findOne(id);
    }
}