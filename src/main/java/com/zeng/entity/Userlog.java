package com.zeng.entity;

public class Userlog {

    private String login_time;
    private String login_name;
    private String login_ip;
    private String login_ornot;
    private String user_operation;


    @Override
    public String toString() {
        return "Userlog{" +
                "login_time='" + login_time + '\'' +
                ", login_name='" + login_name + '\'' +
                ", login_ip='" + login_ip + '\'' +
                ", login_ornot='" + login_ornot + '\'' +
                ", user_operation='" + user_operation + '\'' +
                '}';
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public String getLogin_ornot() {
        return login_ornot;
    }

    public void setLogin_ornot(String login_ornot) {
        this.login_ornot = login_ornot;
    }

    public String getUser_operation() {
        return user_operation;
    }

    public void setUser_operation(String user_operation) {
        this.user_operation = user_operation;
    }
}
