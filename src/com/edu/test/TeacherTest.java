package com.edu.test;

import com.edu.dao.TeacherMapper;
import com.edu.po.Teacher;
import com.edu.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * @author maGuoWei
 * @Description 教师测试类
 * @date 2021/10/2 13:42
 */
public class TeacherTest {


    //    查询所有教师信息
    @Test
    public void selectAllTeachers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    //    通过教师姓名模糊查询教师信息
    @Test
    public void selectTeacherByName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectTeacherByName("n");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    //    通过教师编号精确查询教师信息
    @Test
    public void selectTeacherById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectTeacherById(2);
        System.out.println(teacher);
        sqlSession.close();
    }

    //    添加教师信息
    @Test
    public void addTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher("TEST", "男", 29, "软件工程", 8000, "123abcdef");
        int i = mapper.addTeacher(teacher);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        sqlSession.close();
        System.out.println(teacher.gettNo());
    }

    //    通过教师编号删除教师信息
    @Test
    public void deleteTeacherById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        int i = mapper.deleteTeacherById(7);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.close();
    }

    //    修改教师信息
    @Test
    public void updateTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.settNo(6);
        teacher.settAge(35);
        teacher.settSalary(7000);
        int i = mapper.updateTeacher(teacher);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sqlSession.close();
    }
}
