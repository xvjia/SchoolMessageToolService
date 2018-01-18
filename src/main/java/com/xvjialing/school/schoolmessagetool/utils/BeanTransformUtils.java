package com.xvjialing.school.schoolmessagetool.utils;

import com.alibaba.fastjson.JSON;
import com.xvjialing.school.schoolmessagetool.bean.Message;
import com.xvjialing.school.schoolmessagetool.bean.PostMessage;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.bean.user.PostStudent;
import com.xvjialing.school.schoolmessagetool.bean.user.PostTeacher;
import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;
import com.xvjialing.school.schoolmessagetool.bean.user.User;

public final class BeanTransformUtils {

    public static Message transformPostMessage(PostMessage postMessage) throws Exception {
        Message message = new Message();
        message.setMessage(postMessage.getMessage());
        message.setTeacher_id(JSON.parseObject(postMessage.getPublisher(), Teacher.class).getId());
        message.setSchoolClass(JSON.parseObject(postMessage.getSchoolClass(), SchoolClass.class));
        message.setTime(TimeUtils.tranforDate(postMessage.getTime()));
        message.setMessageType(postMessage.getMessageType());
        return message;
    }

    public static User transformPostStudent(PostStudent postStudent){
        User user=new User();
        user.setUsername(postStudent.getUsername());
        user.setName(postStudent.getName());
        user.setPassword(postStudent.getPassword());
        user.setRole(postStudent.getRole());
        return user;
    }

    public static User transformPostTecher(PostTeacher postTeacher){
        User user=new User();
        user.setUsername(postTeacher.getUsername());
        user.setName(postTeacher.getName());
        user.setPassword(postTeacher.getPassword());
        user.setRole(postTeacher.getRole());
        return user;
    }
}