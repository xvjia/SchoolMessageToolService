package com.xvjialing.school.schoolmessagetool.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    private Date time;

    private String message;

    private Integer messageType;

//    @ManyToOne(targetEntity = Teacher.class)
//    @JoinColumn(name = "teacher_id",nullable = false)
    private Integer teacher_id;

//    @ManyToMany(mappedBy = "messageList")
//    private List<Student> studentList;

    @ManyToOne(targetEntity = SchoolClass.class)
    @JoinColumn(name = "school_class_id",nullable = false)
    private SchoolClass schoolClass;


    public Message() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    @JsonBackReference
    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }


//    public List<Student> getStudentList() {
//        return studentList;
//    }


//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", time=" + time +
                ", message='" + message + '\'' +
                ", messageType=" + messageType +
                ", teacher_id=" + teacher_id +
                ", schoolClass=" + schoolClass +
                '}';
    }
}