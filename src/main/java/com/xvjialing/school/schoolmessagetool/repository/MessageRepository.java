package com.xvjialing.school.schoolmessagetool.repository;

import com.xvjialing.school.schoolmessagetool.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
