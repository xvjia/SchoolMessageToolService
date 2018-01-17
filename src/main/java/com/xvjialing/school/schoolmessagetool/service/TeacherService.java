package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.commons.UserType;
import com.xvjialing.school.schoolmessagetool.repository.TeacherRepository;
import com.xvjialing.school.schoolmessagetool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Teacher addTeacher(User user, List<SchoolClass> schoolClassList, String subject){
        User user1 = userRepository.save(user);
        Teacher teacher=new Teacher();
        teacher.setUser(user1);
        teacher.setSchoolClassList(schoolClassList);
//        teacher.getSchoolClassList().addAll(schoolClassList);
        teacher.setSubject(subject);
        return teacherRepository.save(teacher);
    }

    public boolean isExistsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public List<Teacher> getTeacherList(){
        return teacherRepository.findAll();
    }

    public Teacher findById(int id){
        return teacherRepository.findOne(id);
    }

    public Teacher findByUser(User user){
        return teacherRepository.findByUser(user);
    }

    public Teacher login(String username,String password){
        User user = userRepository.findByUsernameAndPasswordAndRole(username, password, UserType.USER_TYPE_TEACHER);
        if (user==null){
            return null;
        }else {
            return teacherRepository.findByUser(user);
        }

    }

}