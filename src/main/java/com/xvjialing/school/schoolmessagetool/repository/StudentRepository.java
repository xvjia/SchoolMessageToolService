package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByUser(User user);
}
