package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.Message;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllBySchoolClassAndAndMessageType(SchoolClass schoolClass,Integer messageType);
}
