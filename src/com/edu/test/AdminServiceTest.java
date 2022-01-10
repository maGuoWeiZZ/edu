package com.edu.test;


import com.edu.po.*;
import com.edu.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AdminServiceTest {

    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    AdminService service = app.getBean("adminService", AdminService.class);

    @Test
    public void adminLogin() {
        User user = service.adminLogin("admin", "1");
        if (user != null) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
    }

    @Test
    public void modifyPwd() {
        int i = service.modifyPwd(1, "1");
        if (i > 0) {
            System.out.println("修改密码成功！");
        } else {
            System.out.println("修改密码失败！");
        }
    }

    @Test
    public void selectAllStu() {
        List<Student> studentList = service.selectAllStu();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void selectStuBySno() {
        Student student = service.selectStuBySno(1);
        System.out.println(student);
    }

    @Test
    public void addStu() {
        Student student = new Student("王红", "男", 19, "软件工程", "2019级2班", "qwer");
        int i = service.addStu(student);
        if (i > 0) {
            System.out.println("添加学生成功！");
        } else {
            System.out.println("添加学生失败！");
        }
    }

    @Test
    public void updateStu() {
        Student student = service.selectStuBySno(1);
        student.setsAge(21);
//        student.setsPassword(null);
        int i = service.updateStu(student);
        if (i > 0) {
            System.out.println("修改学生成功！");
        } else {
            System.out.println("修改学生失败！");
        }
    }

    @Test
    public void deleteStuById() {
        int i = service.deleteStuById(28);
        if (i > 0) {
            System.out.println("修改学生成功！");
        } else {
            System.out.println("修改学生失败！");
        }
    }

    @Test
    public void selectSCBySno() {
        List<SC> scList = service.selectSCBySno(1);
        for (SC sc : scList) {
            System.out.println(sc);
        }
    }

    @Test
    public void selectSCByCno() {
        List<SC> scList = service.selectSCByCno(1);
        for (SC sc : scList) {
            System.out.println(sc);
        }
    }


    @Test
    public void updateScore() {
        int i = service.updateScore(1, 1, 95);
        if (i > 0) {
            System.out.println("修改成绩成功！");
        } else {
            System.out.println("修改成绩失败！");
        }
    }

    @Test
    public void selectAllTeachers() {
        List<Teacher> teacherList = service.selectAllTeachers();
        System.out.println(teacherList);
    }

    @Test
    public void selectTeacherById() {
        Teacher teacher = service.selectTeacherById(1);
        System.out.println(teacher);
    }

    @Test
    public void addTeacher() {
        int i = service.addTeacher(new Teacher("test", "男", 12, "cc", 2444, "123456"));
        if (i > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    @Test
    public void updateTeacher() {
        Teacher teacher = new Teacher(1, null, null, 22, null, 10000, null);
        int i = service.updateTeacher(teacher);
        if (i > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    @Test
    public void deleteTeacher() {
        int i = service.deleteTeacher(11);
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void selectAllUsers() {
        List<User> users = service.selectAllUsers();
        System.out.println(users);
    }

    @Test
    public void selectUserById() {
        User user = service.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserByUsername() {
        User user = service.selectUserByUsername("admn");
        System.out.println(user);
    }

    @Test
    public void addUser() {
        User user = new User("测试", "1122", new UserDetail("张三", "123@qq.com", "13345678899"));
        int i = service.addUser(user);
        if (i >0 ) {
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    @Test
    public void updateUser() {
        User user = new User(14,"测试张六", "1122", new UserDetail(null, "zhangliu@qq.com", null));
        int i = service.updateUser(user);
        if (i > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    @Test
    public void deleteUser() {
        int i = service.deleteUser(14);
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }



}
