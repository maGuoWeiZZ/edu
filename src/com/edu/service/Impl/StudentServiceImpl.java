package com.edu.service.Impl;

import com.edu.dao.SCMapper;
import com.edu.dao.SelectCourseMapper;
import com.edu.dao.StudentMapper;
import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.po.Student;
import com.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SCMapper scMapper;
    @Autowired
    private SelectCourseMapper selectCourseMapper;

    @Override
    public Student studentLogin(Integer sNo, String password) {

//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudentByIdAndPassword(sNo, password);
//        sqlSession.close();
        return student;

    }

    @Override
    public int studentModifyPassword(Integer sNo, String password) {

        int i = studentMapper.updateStudent(new Student(sNo, password));
        return i;

    }

    @Override
    public List<SC> getSCListBySno(Integer sNo) {

        List<SC> scList = scMapper.selectSCBySno(sNo);
        return scList;

    }

    @Override
    public SC getSCBySnoAndCno(Integer sNo, Integer cNo) {

        SC sc = scMapper.selectSCBySnoAndCno(sNo, cNo);
        return sc;

    }

    @Override
    public List<Course> getSelectCourseList(Integer sNo) {

        List<Course> courseList = selectCourseMapper.selectSelectCourseBySNo(sNo);
        return courseList;

    }

    @Override
    public List<Course> getNotSelectCourseList(Integer sNo) {

        List<Course> courses = selectCourseMapper.selectNotSelectCourseBySNo(sNo);
        return courses;

    }

    @Override
    public int selectCourse(Integer sNo, Integer cNo) {

        int i = selectCourseMapper.addSelectCourse(sNo, cNo);
        return i;
    }

    @Override
    public int deleteSelectCourse(Integer sNo, Integer cNo) {

        int j = selectCourseMapper.deleteSelectCourseBySnoAndCno(sNo, cNo);
        int i = scMapper.deleteSCBySnoAndCno(sNo, cNo);
        return i + j;
    }

}
