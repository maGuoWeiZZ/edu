package com.edu.test;

import com.edu.po.SC;
import com.edu.po.Teacher;
import com.edu.service.Impl.TeacherServiceImpl;
import com.edu.service.StudentService;
import com.edu.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TeacherServiceTest {

    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    private TeacherService service = app.getBean("teacherService",TeacherService.class);

    @Test
    public void teacherLogin() {
        Teacher teacher = service.teacherLogin(1, "1");
        if (teacher != null) {
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }
    }

    @Test
    public void teacherModifyPassword() {
        int i = service.teacherModifyPassword(1,"1");
        if (i > 0) {
            System.out.println("修改密码成功");
        }else{
            System.out.println("修改密码失败");
        }

    }

    @Test
    public void selectScoreBySno() {
        List<SC> scList = service.selectScoreBySno(1);
        for (SC sc : scList) {
            System.out.println(sc);
        }
    }

    @Test
    public void selectScoreByCno() {
        List<SC> scList = service.selectScoreByCno(1);
        for (SC sc : scList) {
            System.out.println(sc);
        }
    }

    @Test
    public void inputScore() {
        int i = service.inputScore(1, 2, 90);
        if (i > 0) {
            System.out.println("录入成绩成功");
        }else{
            System.out.println("录入成绩失败");
        }
    }




}
