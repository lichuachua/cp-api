package cn.yunding.cp.dto;

import javax.mail.Session;

public class Email {
//    Session session,
//    String sendMail,
//    String receiveMail,
//    String title,
//    String body
    public Session session;
    public String sendMail;
    public String receive;
    public String title;
    public int body;

    public Session getSession() {

        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "session=" + session +
                ", sendMail='" + sendMail + '\'' +
                ", receive='" + receive + '\'' +
                ", title='" + title + '\'' +
                ", body=" + body +
                '}';
    }
}
