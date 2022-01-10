package com.edu.po;

/**
 * @Description 用户
 * @author maGuoWei
 * @date 2021/9/28 21:34
 */
public class User{

    private Integer uid;
    private String username;
    private String password;
    private UserDetail detail;//一对一user详细信息

    public User() {
    }

    public User(Integer uid) {
        this.uid = uid;
    }

    public User(Integer uid, String username, String password, UserDetail detail) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.detail = detail;
    }

    public User(String username, String password, UserDetail detail) {
        this.username = username;
        this.password = password;
        this.detail = detail;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getDetail() {
        return detail;
    }

    public void setDetail(UserDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", detail=" + detail +
                '}';
    }
}
