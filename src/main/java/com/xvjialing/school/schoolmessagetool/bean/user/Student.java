package com.xvjialing.school.schoolmessagetool.bean.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id",unique = true,nullable = false,updatable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "school_class_id",referencedColumnName = "id",nullable = false,updatable = false)
    private SchoolClass schoolClass;

//    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//    private List<Message> messageList;

    public Student() {
    }

//    public Student(List<Message> messageList) {
//        this.messageList = messageList;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    @JsonBackReference
    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

//    public List<Message> getMessageList() {
//        return messageList;
//    }

//    @JsonBackReference
//    public void setMessageList(List<Message> messageList) {
//        this.messageList = messageList;
//    }




    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user=" + user +
                ", schoolClass=" + schoolClass +
                '}';
    }
}