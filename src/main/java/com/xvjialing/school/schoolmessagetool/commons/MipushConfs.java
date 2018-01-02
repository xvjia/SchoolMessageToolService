package com.xvjialing.school.schoolmessagetool.commons;

public final class MipushConfs {

    /**
     * 应用信息
     */
    public static String APPSECRET= "0T9DgeXaKF6QJpD8Afuquw==";
    public static String APPKEY= "5961768756679";
    public static String APPID= "2882303761517687679";
    public static String PACKAGENAME="com.lytech.xvjialing.schoolmessagetool";

    /**
     * 服务器信息
     */
    public static String SERVER_HOST="http://www.xvjialing.xyz:8080";

    /**
     * 消息传递方式
     */
    public static int PASSTHROUGH_MESSAGE=1; //透传消息
    public static int NOTIFICATION_BAR_MESSAGE =0; //通知栏消息

    /**
     * 消息通知方式
     */
    public static int NOTIFY_ALL=-1;
    public static int NOTIFY_SOUND  = 1;   // 使用默认提示音提示
    public static int NOTIFY_VIBRATE = 2;   // 使用默认震动提示
    public static int NOTIFY_LIGHTS = 4;    // 使用默认led灯光提示



}
