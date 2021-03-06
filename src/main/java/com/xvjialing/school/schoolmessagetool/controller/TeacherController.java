package com.xvjialing.school.schoolmessagetool.controller;

import com.alibaba.fastjson.JSON;
import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.bean.SchoolClass;
import com.xvjialing.school.schoolmessagetool.bean.user.PostTeacher;
import com.xvjialing.school.schoolmessagetool.bean.user.Teacher;
import com.xvjialing.school.schoolmessagetool.bean.user.User;
import com.xvjialing.school.schoolmessagetool.service.TeacherService;
import com.xvjialing.school.schoolmessagetool.utils.BeanTransformUtils;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class TeacherController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher")
    public Result<Teacher> addTeacher(PostTeacher postTeacher){
        User user = BeanTransformUtils.transformPostTecher(postTeacher);
        if (teacherService.isExistsByUsername(user.getUsername())){
            return ResultUtils.failed("该用户名已被注册");
        }
        Teacher teacher1 = teacherService.addTeacher(user, JSON.parseArray(postTeacher.getClassList(), SchoolClass.class),postTeacher.getSubject());
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

    @GetMapping("/teacher/{id}")
    public Result<Teacher> getTeacher(@PathVariable("id") int id){
        Teacher teacher = teacherService.findById(id);
        if (teacher==null){
            return ResultUtils.failed("教师获取失败");
        }else {
            return ResultUtils.success("成功",teacher);
        }
    }


}