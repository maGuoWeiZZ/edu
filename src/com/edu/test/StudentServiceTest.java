package com.edu.test;

import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.po.Student;
import com.edu.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentServiceTest {

    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    private StudentService service = app.getBean("studentService",StudentService.class);

    @Test
    public void studentLogin() {

        Student student = service.studentLogin(1, "1");
        if (student != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

    }

    @Test
    public void studentModifyPassword() {
        int i = service.studentModifyPassword(1, "1");
        if (i == 1) {
            System.out.println("修改密码成功！");
        } else if (i == 0) {
            System.out.println("修改密码失败！");
        }
    }

    @Test
    public void getSCListBySno() {
        List<SC> scList = service.getSCListBySno(1);
        for (SC sc : scList) {
            System.out.println(sc);
        }
    }

    @Test
    public void getSCBySnoAndCno() {
        SC sc = service.getSCBySnoAndCno(1, 1);
        System.out.println(sc);
    }

    @Test
    public void getSelectCourseList() {
        List<Course> courseList = service.getSelectCourseList(1);
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void getNotSelectCourseList() {
        List<Course> courseList = service.getNotSelectCourseList(1);
        for (Course course : courseList) {
            System.out.println(course);
        }
    }


    @Test
    public void selectCourse() {
        int i = service.selectCourse(3, 6);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void deleteSelectCourse() {
        int i = service.deleteSelectCourse(3, 6);
        if (i > 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }


}


