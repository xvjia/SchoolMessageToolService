package com.xvjialing.school.schoolmessagetool.bean.user;

import com.xvjialing.school.schoolmessagetool.bean.Message;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id",unique = true,nullable = false,updatable = false)
    private User user;

    @OneToMany(mappedBy = "publisher",cascade = {CascadeType.REFRESH})
    private Set<Message> sendMessageSet;

    @ManyToMany(mappedBy = "teacherList")
    private List<SchoolClass> classList;

    public Teacher() {
    }

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

    public Set<Message> getSendMessageSet() {
        return sendMessageSet;
    }

    public void setSendMessageSet(Set<Message> sendMessageSet) {
        this.sendMessageSet = sendMessageSet;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", user:" + user +
                ", sendMessageSet:" + sendMessageSet +
                '}';
    }
}