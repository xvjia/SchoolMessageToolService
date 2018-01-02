package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.commons.UserType;
import com.xvjialing.school.schoolmessagetool.repository.StudentRepository;
import com.xvjialing.school.schoolmessagetool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Student addStudent(User user){
        User user1 = userRepository.save(user);
        Student student = new Student();
        student.setUser(user1);
        return studentRepository.save(student);
    }

    public boolean isExistsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public Student login(String username,String password){
        User user = userRepository.findByUsernameAndPasswordAndRole(username, password, UserType.USER_TYPE_STUDENT);
        if(user==null){
            return null;
        }
        return studentRepository.findByUser(user);
    }

}