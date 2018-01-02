package com.xvjialing.school.schoolmessagetool.controller;

import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.service.StudentService;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Result<Student> addStudent(User user){
        if (studentService.isExistsByUsername(user.getUsername())){
            return ResultUtils.failed("该用户名已被注册");
        }
        Student student = studentService.addStudent(user);
        if (student==null){
            return ResultUtils.failed("注册学生失败");
        }
        return ResultUtils.success("成功",student);
    }

    @PostMapping("/student/login")
    public Result<Student> login(String username,String password) {
        Student student = studentService.login(username, password);
        if (student == null) {
            return ResultUtils.failed("用户名或密码错误");
        } else {
            return ResultUtils.success("成功", student);
        }
    }

}