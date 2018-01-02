package com.xvjialing.school.schoolmessagetool.bean.user;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id",unique = true,nullable = false,updatable = false)
    private User user;

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

//    public List<Message> getMessageList() {
//        return messageList;
//    }

//    @JsonBackReference
//    public void setMessageList(List<Message> messageList) {
//        this.messageList = messageList;
//    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", user:" + user +
//                ", messageList:" + messageList +
                '}';
    }
}