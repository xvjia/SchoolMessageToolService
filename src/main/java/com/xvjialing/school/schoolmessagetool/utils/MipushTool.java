package com.xvjialing.school.schoolmessagetool.utils;

import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.TargetedMessage;
import com.xvjialing.school.schoolmessagetool.commons.MipushConfs;

import java.util.ArrayList;
import java.util.List;

public class MipushTool {

    /**
     * 构建推送消息体
     * 构建发送给Android设备的Message对象。
     * @param msg
     * @param title
     * @param description
     * @param messageType
     * @param notifyType
     * @return
     * @throws Exception
     */
    public static Message buildMessage(String msg,String title,String description,int messageType,int notifyType) throws Exception {

        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(msg)
                .restrictedPackageName(MipushConfs.PACKAGENAME)
                .passThrough(messageType)  //消息使用透传方式
                .notifyType(notifyType)     // 使用默认提示音提示
                .extra("flow_control", "4000")     // 设置平滑推送, 推送速度4000每秒(qps=4000)
                .build();
        return message;
    }

    /**
     * 构建TargetedMessage列表
     * TargetedMessage封装了MiPush推送服务系统中的消息Message对象，和该Message对象所要发送到的目标。
     * @param messageList
     * @param targetType
     * @param target
     * @return
     * @throws Exception
     */
    public static List<TargetedMessage> buildTargetedMessages(List<Message> messageList,int targetType, String target) throws Exception {
        List<TargetedMessage> messages = new ArrayList<TargetedMessage>();
        for (Message item:messageList){
            TargetedMessage targetedMessage = new TargetedMessage();
            targetedMessage.setTarget(targetType,target);
            targetedMessage.setMessage(item);
            messages.add(targetedMessage);
        }
//
//        TargetedMessage message1 = new TargetedMessage();
//        message1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "alias1");
//        message1.setMessage(buildMessage("msg1","msg1","msg1",MipushConfs.PASSTHROUGH_MESSAGE,MipushConfs.NOTIFY_ALL));
//        messages.add(message1);
//        TargetedMessage message2 = new TargetedMessage();
//        message2.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "alias2");
//        message2.setMessage(buildMessage("msg1","msg1","msg1",MipushConfs.PASSTHROUGH_MESSAGE,MipushConfs.NOTIFY_ALL));
//        messages.add(message2);
        return messages;
    }


}