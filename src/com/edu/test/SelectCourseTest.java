package com.edu.test;

import com.edu.dao.SelectCourseMapper;
import com.edu.po.Course;
import com.edu.po.Student;
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
 * @Description SelectCourse测试类
 * @date 2021/10/3 10:58
 */
public class SelectCourseTest {

    //    按学号查询选课信息
    @Test
    public void selectSelectCourseBySNo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SelectCourseMapper mapper = sqlSession.getMapper(SelectCourseMapper.class);
        List<Course> courses = mapper.selectSelectCourseBySNo(1);
        for (Course course : courses) {
            System.out.println(course);
        }
        sqlSession.close();
    }

    //    按课程号查询选课信息
    @Test
    public void selectSelectCourseByCNo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SelectCourseMapper mapper = sqlSession.getMapper(SelectCourseMapper.class);
        List<Student> students = mapper.selectSelectCourseByCNo(1);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    //    按学号查询未选课信息
    @Test
    public void selectNotSelectCourseBySNo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SelectCourseMapper mapper = sqlSession.getMapper(SelectCourseMapper.class);
        List<Course> courses = mapper.selectNotSelectCourseBySNo(1);
        for (Course course : courses) {
            System.out.println(course);
        }
        sqlSession.close();
    }

    //    添加选课信息
    @Test
    public void addSelectCourse() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SelectCourseMapper mapper = sqlSession.getMapper(SelectCourseMapper.class);
        int i = mapper.addSelectCourse(1, 6);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
        sqlSession.close();
    }

    //    根据学号和课程号删除选课信息
    @Test
    public void deleteSelectCourseBySnoAndCno() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SelectCourseMapper mapper = sqlSession.getMapper(SelectCourseMapper.class);
        int i = mapper.deleteSelectCourseBySnoAndCno(1, 1);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        sqlSession.close();
    }

}
