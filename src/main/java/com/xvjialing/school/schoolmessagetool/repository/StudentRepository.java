package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByUser(User user);

//    @Query("select student from  Student student join student.schoolClass s where student.user = ?1")
//    Student findByUser(User user);
//
//    Student findBySchoolClass(SchoolClass schoolClass);
//
//    @Query("select student from Student student join student.schoolClass s where student.id=?1")
//    Student findById(Integer id);

}
