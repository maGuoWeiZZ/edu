package com.edu.po;
/**
 * @Description 用户详细信息
 * @author maGuoWei
 * @date 2021/11/2 20:49
 */
public class UserDetail {

    private Integer did;
    private String realName;
    private String email;
    private String phone;

    public UserDetail() {
    }

    public UserDetail(Integer did) {
        this.did = did;
    }

    public UserDetail(Integer did, String realName, String email, String phone) {
        this.did = did;
        this.realName = realName;
        this.email = email;
        this.phone = phone;
    }

    public UserDetail(String realName, String email, String phone) {
        this.realName = realName;
        this.email = email;
        this.phone = phone;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "did=" + did +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
