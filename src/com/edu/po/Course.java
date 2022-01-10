package com.edu.po;


/**
 * @author maGuoWei
 * @Description 课程
 * @date 2021/9/28 21:30
 */
//别名
//@Alias(value = "course")
public class Course {

    private Integer cNo;//课程号
    private String cName;//课程名
    private Integer credit;//学分
    private String remarks;//类型（选修/必修）

    public Course() {
    }

    public Course(Integer cNo, String cName, Integer credit, String remarks) {
        this.cNo = cNo;
        this.cName = cName;
        this.credit = credit;
        this.remarks = remarks;
    }

    public Course(Integer cNo) {
        this.cNo = cNo;
    }

    public Course(String cName, Integer credit, String remarks) {
        this.cName = cName;
        this.credit = credit;
        this.remarks = remarks;
    }

    public Integer getcNo() {
        return cNo;
    }

    public void setcNo(Integer cNo) {
        this.cNo = cNo;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cNo=" + cNo +
                ", cName='" + cName + '\'' +
                ", credit=" + credit +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
