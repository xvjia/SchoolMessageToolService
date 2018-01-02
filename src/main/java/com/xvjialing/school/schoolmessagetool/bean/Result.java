package com.xvjialing.school.schoolmessagetool.bean;

public class Result<T> {

    private boolean status;

    private String message;

    private T data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "status:" + status +
                ", message:'" + message + '\'' +
                ", data:" + data +
                '}';
    }
}