package com.edu.po;
/**
 * @Description 教师
 * @author maGuoWei
 * @date 2021/9/28 21:33
 */
public class Teacher {

    private Integer tNo;//职工号
    private String tName;//姓名
    private String tSex;//性别
    private Integer tAge;//年龄
    private String tDept;//专业
    private Integer tSalary;//工薪
    private String tPassword;//密码

    public Teacher() {
    }

    public Teacher(Integer tNo, String tPassword) {
        this.tNo = tNo;
        this.tPassword = tPassword;
    }

    public Teacher(Integer tNo) {
        this.tNo = tNo;
    }

    public Teacher(String tName, String tSex, Integer tAge, String tDept, Integer tSalary, String tPassword) {
        this.tName = tName;
        this.tSex = tSex;
        this.tAge = tAge;
        this.tDept = tDept;
        this.tSalary = tSalary;
        this.tPassword = tPassword;
    }

    public Teacher(Integer tNo, String tName, String tSex, Integer tAge, String tDept, Integer tSalary, String tPassword) {
        this.tNo = tNo;
        this.tName = tName;
        this.tSex = tSex;
        this.tAge = tAge;
        this.tDept = tDept;
        this.tSalary = tSalary;
        this.tPassword = tPassword;
    }

    public Integer gettNo() {
        return tNo;
    }

    public void settNo(Integer tNo) {
        this.tNo = tNo;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    public String gettDept() {
        return tDept;
    }

    public void settDept(String tDept) {
        this.tDept = tDept;
    }

    public Integer gettSalary() {
        return tSalary;
    }

    public void settSalary(Integer tSalary) {
        this.tSalary = tSalary;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tNo=" + tNo +
                ", tName='" + tName + '\'' +
                ", tSex='" + tSex + '\'' +
                ", tAge=" + tAge +
                ", tDept='" + tDept + '\'' +
                ", tSalary=" + tSalary +
                '}';
    }
}
