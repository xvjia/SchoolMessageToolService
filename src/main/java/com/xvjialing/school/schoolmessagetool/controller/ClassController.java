package com.xvjialing.school.schoolmessagetool.controller;

import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.service.ClassService;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class ClassController {

    @Autowired
    ClassService classService;

    @PostMapping("/class")
    public Result<SchoolClass> addClass(SchoolClass schoolClass){
        if (classService.existsByClassNumber(schoolClass.getClassNumber())){
            return ResultUtils.failed("该班级号已注册");
        }
        SchoolClass schoolClass1 = classService.addClass(schoolClass);
        return ResultUtils.success("注册成功",schoolClass1);
    }

    @GetMapping("/class")
    public Result<List<SchoolClass>> getClassList(){
        return ResultUtils.success("成功",classService.getClassList());
    }
}