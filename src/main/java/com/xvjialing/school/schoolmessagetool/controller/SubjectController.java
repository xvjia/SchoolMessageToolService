package com.xvjialing.school.schoolmessagetool.controller;

import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.bean.Subject;
import com.xvjialing.school.schoolmessagetool.service.SubjectService;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping(value = "/subject")
    public Result<List<Subject>> getSubjectList(){
        List<Subject> subjectList = subjectService.getSubjectList();
        return ResultUtils.success("成功",subjectList);
    }

    @PostMapping(value = "/subject")
    public Result<Subject> addSubject(Subject subject){
        Subject subject1 = subjectService.addSubject(subject);
        if (subject1==null){
            return ResultUtils.failed("添加失败");
        }
        return ResultUtils.success("成功",subject1);
    }


}