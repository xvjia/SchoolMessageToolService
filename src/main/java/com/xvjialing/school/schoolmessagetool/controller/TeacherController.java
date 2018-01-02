package com.xvjialing.school.schoolmessagetool.controller;

import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.service.TeacherService;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class TeacherController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher")
    public Result<Teacher> addTeacher(User user){
        if (teacherService.isExistsByUsername(user.getUsername())){
            return ResultUtils.failed("该用户名已被注册");
        }
        Teacher teacher1 = teacherService.addTeacher(user);
        if (teacher1==null){
            return ResultUtils.failed("教师注册失败");
        }
        return ResultUtils.success("教师注册成功",teacher1);

    }

    @GetMapping("/teacher")
    public Result<List<Teacher>> getTeacherList(){
        List<Teacher> teacherList=new ArrayList<>();
        teacherList=teacherService.getTeacherList();
        Result result = ResultUtils.success("获取成功", teacherList);
        return result;
    }

    @PostMapping("/teacher/login")
    public Result<Teacher> login(String username,String password){
        Teacher teacher = teacherService.login(username, password);
        if (teacher==null){
            return ResultUtils.failed("用户名或密码错误");
        }
        return ResultUtils.success("success",teacher);
    }

}