package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findByUser(User user);
}
