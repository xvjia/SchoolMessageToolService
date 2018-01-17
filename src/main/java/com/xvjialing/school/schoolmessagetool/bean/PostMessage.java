package com.xvjialing.school.schoolmessagetool.bean;

public class PostMessage {

    private String time;

    private String message;

    private String publisher;

    private String schoolClass;

    private Integer messageType;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "PostMessage{" +
                "time='" + time + '\'' +
                ", message='" + message + '\'' +
                ", publisher='" + publisher + '\'' +
                ", schoolClass='" + schoolClass + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}