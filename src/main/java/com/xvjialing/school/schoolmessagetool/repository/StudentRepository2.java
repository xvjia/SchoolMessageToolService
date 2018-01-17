package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository2 extends CrudRepository<Student,Integer> {

    @Query("select student from Student student")
    List<Student> find();

    @Query(value = "SELECT * FROM student",nativeQuery = true)
    List<Student> test();
}
