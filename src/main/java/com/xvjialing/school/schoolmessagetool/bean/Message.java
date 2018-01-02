package com.xvjialing.school.schoolmessagetool.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    private Long timeStamp;

    private String message;

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id",unique = true,nullable = false,updatable = false)
    private Teacher publisher;

//    @ManyToMany(mappedBy = "messageList")
//    private List<Student> studentList;

    @ManyToOne(targetEntity = SchoolClass.class)
    @JoinColumn(name = "school_class_id",unique = true,nullable = false,updatable = false)
    private SchoolClass schoolClass;


    public Message() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Teacher getPublisher() {
        return publisher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    @JsonBackReference
    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @JsonBackReference
    public void setPublisher(Teacher publisher) {
        this.publisher = publisher;
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
                ", timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", publisher=" + publisher +
                ", schoolClass=" + schoolClass +
                '}';
    }
}