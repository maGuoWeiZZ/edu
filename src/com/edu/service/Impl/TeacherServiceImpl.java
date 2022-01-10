package com.edu.service.Impl;

import com.edu.dao.SCMapper;
import com.edu.dao.TeacherMapper;
import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.po.Student;
import com.edu.po.Teacher;
import com.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private SCMapper scMapper;

    @Override
    public Teacher teacherLogin(Integer tNo, String password) {
        Teacher teacher = teacherMapper.selectTeacherById(tNo);
        if (teacher != null && teacher.gettPassword().equals(password)) {
            return teacher;
        }
        return null;
    }

    @Override
    public int teacherModifyPassword(Integer tNo, String password) {
        int i = teacherMapper.updateTeacher(new Teacher(tNo, password));
        return i;
    }

    @Override
    public List<SC> selectScoreBySno(Integer sNo) {
        List<SC> scList = scMapper.selectSCBySno(sNo);
        return scList;
    }

    @Override
    public List<SC> selectScoreByCno(Integer cNo) {
        List<SC> scList = scMapper.selectSCByCno(cNo);
        return scList;
    }

    @Override
    public List<SC> selectScoreByCnoOrderByScore(Integer cNo) {
        List<SC> scList = scMapper.selectSCByCnoOrderByScore(cNo);
        return scList;
    }

    @Override
    public int inputScore(Integer sNo, Integer cNo, Integer score) {
        int i = scMapper.modifyScore(new SC(new Student(sNo), new Course(cNo), score));
        return i;
    }
}
