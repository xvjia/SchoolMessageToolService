package com.xvjialing.school.schoolmessagetool.controller;

import com.alibaba.fastjson.JSON;
import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.bean.user.PostStudent;
import com.xvjialing.school.schoolmessagetool.bean.user.Student;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.repository.StudentRepository2;
import com.xvjialing.school.schoolmessagetool.service.StudentService;
import com.xvjialing.school.schoolmessagetool.utils.BeanTransformUtils;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json;charset=UTF-8")
public class StudentController {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository2 studentRepository2;

    @PostMapping("/student")
    public Result<Student> addStudent(PostStudent postStudent){
        User user = BeanTransformUtils.transformPostStudent(postStudent);
        if (studentService.isExistsByUsername(user.getUsername())){
            return ResultUtils.failed("该用户名已被注册");
        }
        Student student = studentService.addStudent(user, JSON.parseObject(postStudent.getSchoolClass(), SchoolClass.class).getId());
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

    @GetMapping("/student/test")
    public void test(){
        List<Student> students = studentRepository2.test();
        for (Student item:students){
            logger.info("student:{}",item.toString());
        }
    }

}