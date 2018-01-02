package com.xvjialing.school.schoolmessagetool.service;

import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User login(String username,String password,int role){
        return userRepository.findByUsernameAndPasswordAndRole(username,password,role);
    }
}