package cn.yunding.cp.dto;

import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class EmailTest {

    public static String myEmailAccount="1065618302@qq.com";
    public static String myEmailPassword="kivwguniibimbcjb";


    public static String myEmailSMTPHOST="smtp.qq.com";
    public static String receiveMailAccount="212666902@qq.com";

    public static void main(String[] args) throws  Exception{
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

        MimeMessage message=createMimeMessage(session, myEmailAccount, receiveMailAccount);
        Transport transport=session.getTransport();


        transport.connect(myEmailAccount,myEmailPassword);
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();

    }

    public  static MimeMessage createMimeMessage(Session session,String sendMail, String receiveMail) throws Exception {
    MimeMessage message=new MimeMessage(session);
    message.setFrom(new InternetAddress(sendMail, "云极", "UTF-8"));
    message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail, "任嘉敏用户", "UTF-8"));
    message.setSubject("云极通知", "UTF-8");
    message.setContent("李宇豪同学你好, 很高兴认识你", "text/html;charset=UTF-8");
    message.setSentDate(new Date());
    message.saveChanges();
    return message;
    }
}
