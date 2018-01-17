package com.xvjialing.school.schoolmessagetool.controller;

import com.xvjialing.school.schoolmessagetool.bean.Message;
import com.xvjialing.school.schoolmessagetool.bean.PostMessage;
import com.xvjialing.school.schoolmessagetool.bean.Result;
import com.xvjialing.school.schoolmessagetool.service.MessageService;
import com.xvjialing.school.schoolmessagetool.utils.BeanTransformUtils;
import com.xvjialing.school.schoolmessagetool.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/message")
    public Result<Message> addMessage(PostMessage postMessage) throws Exception {
        Message message = BeanTransformUtils.transformPostMessage(postMessage);
        Message message1 = messageService.addMessage(message);
        if (message1==null){
            return ResultUtils.failed("添加消息失败");
        }
        return ResultUtils.success("成功",message1);
    }

    @GetMapping("/message")
    public Result<List<Message>> getallMessage(){
        List<Message> messageList = messageService.getMessageList();
        return ResultUtils.success("成功",messageList);
    }

    @GetMapping("/message/{classid}/{messagetype}")
    public Result<List<Message>> findMessageByClass(@PathVariable("classid") int classid,@PathVariable("messagetype") int messagetype){
        List<Message> messageList = messageService.findByClass(classid,messagetype);
        return ResultUtils.success("成功",messageList);
    }
}