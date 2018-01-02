package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndPasswordAndRole(String username,String password,int role);

    boolean existsByUsername(String username);
}
