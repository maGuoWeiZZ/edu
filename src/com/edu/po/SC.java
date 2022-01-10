package com.edu.po;

/**
 * @author maGuoWei
 * @Description 选课
 * @date 2021/9/28 21:36
 */
public class SC {

    private Integer scId;//成绩编号
    private Student student;//学生
    private Course course;//课程
    private Integer score;//分数

    public SC() {
    }

    public SC(Integer scId) {
        this.scId = scId;
    }

    public SC(Student student, Course course, Integer score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public SC(Integer scId, Student student, Course course, Integer score) {
        this.scId = scId;
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public SC(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    @Override
    public String toString() {
        return "SC{" +
                "scId=" + scId +
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }
}
