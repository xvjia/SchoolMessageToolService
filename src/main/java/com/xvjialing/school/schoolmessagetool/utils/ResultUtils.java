package com.xvjialing.school.schoolmessagetool.utils;

import com.xvjialing.school.schoolmessagetool.bean.Result;

public class ResultUtils {

    public static Result success(String msg,Object data){
        Result result=new Result();
        result.setData(data);
        result.setStatus(true);
        result.setMessage(msg);

        return result;
    }

    public static Result failed(String msg){
        Result result=new Result();
        result.setStatus(false);
        result.setMessage(msg);
        return result;
    }
}