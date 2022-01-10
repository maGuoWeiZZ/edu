package com.edu.po;


/**
 * @Description 学生
 * @author maGuoWei
 * @date 2021/9/28 21:31
 */
public class Student {

    private Integer sNo;//学号
    private String sName;//姓名
    private String sSex;//性别
    private Integer sAge;//年龄
    private String sDept;//专业
    private String sClass;//班级
    private String sPassword;//密码

    public Student() {
    }

    public Student(Integer sNo) {
        this.sNo = sNo;
    }

    public Student(String sName, String sSex, Integer sAge, String sDept, String sClass, String sPassword) {
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sDept = sDept;
        this.sClass = sClass;
        this.sPassword = sPassword;
    }

    public Student(Integer sNo, String sPassword) {
        this.sNo = sNo;
        this.sPassword = sPassword;
    }

    public Student(Integer sNo, String sName, String sSex, Integer sAge, String sDept, String sClass, String sPassword) {
        this.sNo = sNo;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sDept = sDept;
        this.sClass = sClass;
        this.sPassword = sPassword;
    }

    public Integer getsNo() {
        return sNo;
    }

    public void setsNo(Integer sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsDept() {
        return sDept;
    }

    public void setsDept(String sDept) {
        this.sDept = sDept;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo=" + sNo +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sAge=" + sAge +
                ", sDept='" + sDept + '\'' +
                ", sClass='" + sClass + '\'' +
                '}';
    }
}
