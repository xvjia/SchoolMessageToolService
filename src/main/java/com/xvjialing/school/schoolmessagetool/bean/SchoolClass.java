package com.xvjialing.school.schoolmessagetool.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;

import javax.persistence.*;
import java.util.List;

@Entity
public class SchoolClass {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String classNumber;

    @OneToMany(mappedBy = "schoolClass")
    private List<Message> messageList;

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> studentList;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "SCHOOLCLASS_TEACHER" ,
//            joinColumns = {@JoinColumn(name = "schoolClass_id",referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")})
    @ManyToMany(mappedBy = "schoolClassList")
    private List<Teacher> teacherList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

//    @JsonBackReference
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    @JsonBackReference
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", classNumber='" + classNumber + '\'' +
                ", messageList=" + messageList +
                ", studentList=" + studentList +
                ", teacherList=" + teacherList +
                '}';
    }
}