package com.edu.test;

import com.edu.dao.CourseMapper;
import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author maGuoWei
 * @Description course测试
 * @date 2021/10/2 21:39
 */
public class CourseTest {

    //    查询所有课程信息
    @Test
    public void selectAllCourse() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courseList = mapper.selectAllCourse();
        for (Course course : courseList) {
            System.out.println(course.getcName());
        }
        sqlSession.close();
    }

    //    通过课程编号精确查询课程信息
    @Test
    public void selectCourseById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        Course course = mapper.selectCourseById(1);
        System.out.println(course);
        sqlSession.close();
    }

    //    通过课程名称模糊查询课程信息
    @Test
    public void selectCourseByName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courseList = mapper.selectCourseByName("java");
        for (Course course : courseList) {
            System.out.println(course.getcName());
        }
        sqlSession.close();
    }

    //    添加课程信息
    @Test
    public void addCourse() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        Course course = new Course("Python设计与开发", 2, "选修");
        int i = mapper.addCourse(course);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        sqlSession.close();
        System.out.println(course.getcNo());
    }

    //    删除课程信息
    @Test
    public void deleteCourseById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        int i = mapper.deleteCourseById(10);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.close();
    }

    //    修改课程信息
    @Test
    public void updateCourse() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Course course = new Course(7, null, 2, "必修");
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        int i = mapper.updateCourse(course);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sqlSession.close();
    }


}
