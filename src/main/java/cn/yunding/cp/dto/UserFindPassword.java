package cn.yunding.cp.dto;

public class UserFindPassword {
    private String captcha;
    private String email;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserFindPassword{" +
                "captcha='" + captcha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
