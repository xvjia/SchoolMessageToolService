package com.xvjialing.school.schoolmessagetool.bean.user;

import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;

    private String subject;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id",unique = true,nullable = false,updatable = false)
    private User user;

//    @ManyToMany(mappedBy = "teacherList")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "schoolclass_teacher",joinColumns = {
            @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    },inverseJoinColumns = {@JoinColumn(name = "schoolClass_id",referencedColumnName = "id")})
    private List<SchoolClass> schoolClassList;

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<SchoolClass> getSchoolClassList() {
        return schoolClassList;
    }

    public void setSchoolClassList(List<SchoolClass> schoolClassList) {
        this.schoolClassList = schoolClassList;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", user=" + user +
                ", schoolClassList=" + schoolClassList +
                '}';
    }
}