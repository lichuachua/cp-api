package cn.yunding.cp.dto;


import cn.yunding.cp.service.impl.UserEmailServiceImpl;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮件工具类
 */
public class Mail {
    public static String myEmailAccount="1065618302@qq.com";
    public static String myEmailPassword="kivwguniibimbcjb";
    public static String myEmailSMTPHOST="smtp.qq.com";
//    UserEmailServiceImpl userEmailService=new UserEmailServiceImpl();

    public static String receiveMailAccount="1019808375@qq.com";
    public static String sendUser="云极";

    public static void send(String receive,String title,String body) throws  Exception{
        Properties props=new Properties();
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.smtp.host", myEmailSMTPHOST);
        props.setProperty("mail.smtp.auth","true");


        final String smtpPort="465";
        props.setProperty("mail.smtp.port",smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback","false");
        props.setProperty("mail.smtp.socketFactory.port",smtpPort);


        Session session=Session.getDefaultInstance(props);
        session.setDebug(true);
//        MimeMessage message=createMimeMessage(session, myEmailAccount, receiveMailAccount);


        MimeMessage message = createMimeMessage(session, myEmailAccount, receive,title,body);

        Transport transport=session.getTransport();
        transport.connect(myEmailAccount,myEmailPassword);
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();

    }

//    public  static MimeMessage createMimeMessage(Session session,String sendMail, String receiveMail) throws Exception {
//        MimeMessage message=new MimeMessage(session);
//        message.setFrom(new InternetAddress(sendMail, "云极", "UTF-8"));
//        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail, "任嘉敏用户", "UTF-8"));
//        message.setSubject("云极通知", "UTF-8");
//        message.setContent("李宇豪同学你好, 很高兴认识你", "text/html;charset=UTF-8");
//        message.setSentDate(new Date());
//        message.saveChanges();
//        return message;
//    }
private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String title,String body) throws Exception {
    // 1. 创建一封邮件
    MimeMessage message = new MimeMessage(session);

    // 2. From: 发件人
    message.setFrom(new InternetAddress(sendMail, sendUser, "UTF-8"));

    // 3. To: 收件人（可以增加多个收件人、抄送、密送）
    message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "尊敬的用户", "UTF-8"));

    // 4. Subject: 邮件主题
    message.setSubject(title, "UTF-8");

    // 5. Content: 邮件正文（可以使用html标签）
    message.setContent(body, "text/html;charset=UTF-8");

    // 6. 设置发件时间
    message.setSentDate(new Date());

    // 7. 保存设置
    message.saveChanges();

    return message;
}
}
