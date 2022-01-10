package com.edu.test;

import com.edu.dao.StudentMapper;
import com.edu.po.Student;
import com.edu.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maGuoWei
 * @Description 学生测试类
 * @date 2021/9/29 21:00
 */
public class StudentTest {

    //    查询所有学生信息
    @Test
    public void selectAllStudents() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSession sqlSession = app.getBean("sqlSession",SqlSession.class);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    //    通过姓名模糊查询学生信息
    @Test
    public void selectStudentByName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudentByName("伟");
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    //    通过学号和密码查询学生信息
    @Test
    public void selectStudentByIdAndPassword(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectStudentByIdAndPassword(1, "2");
        System.out.println(student);
        sqlSession.close();
    }

    //    通过学号精确查询学生信息
    @Test
    public void selectStudentById() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) app.getBean("student");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        student = mapper.selectStudentById(1);
        System.out.println(student);
        System.out.println(student.getsPassword());
        sqlSession.close();
    }

    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = app.getBean("student", Student.class);
        System.out.println(student);
    }

    //    根据集合中的学号批量查询学生信息
    @Test
    public void selectStudentByIds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        List<Student> students = mapper.selectStudentByIds(list);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //添加学生信息
    @Test
    public void addStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = new Student("lisa", "女", 17, "软件工程", "2019级1班", "123456");
        int i = mapper.addStudent(stu);
        sqlSession.commit();//提交
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        sqlSession.close();
        System.out.println(stu.getsNo());
    }

    //    批量添加学生信息
    @Test
    public void addStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Student> students = new ArrayList<>();
        students.add(new Student("p1", "男", 12, "ceshi", "2ban", "123465"));
        students.add(new Student("p2", "男", 12, "ceshi", "2ban", "132456"));
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.addStudents(students);
        sqlSession.commit();//提交
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        sqlSession.close();
    }

    //    修改学生信息
    @Test
    public void updateStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setsNo(1);
        student.setsPassword("9624586");
        int i = mapper.updateStudent(student);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sqlSession.close();
    }

    @Test
    public void deleteStudentById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.deleteStudentById(21);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功");
        } else
            System.out.println("删除失败");
        sqlSession.close();
    }

}



