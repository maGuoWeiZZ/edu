package com.edu.service.Impl;

import com.edu.dao.SCMapper;
import com.edu.dao.StudentMapper;
import com.edu.dao.TeacherMapper;
import com.edu.dao.UserMapper;
import com.edu.po.*;
import com.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SCMapper scMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public User adminLogin(String username, String password) {
        User user = userMapper.selectUserByUsernameLogin(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public int modifyPwd(Integer uid, String password) {
        User user = new User();
        user.setUid(uid);
        user.setPassword(password);
        int i = userMapper.updateUserWithDetail(user);
        return i;
    }

    @Override
    public List<Student> selectAllStu() {
        List<Student> stuList = studentMapper.selectAllStudents();
        return stuList;
    }

    @Override
    public Student selectStuBySno(Integer sNo) {
        Student student = studentMapper.selectStudentById(sNo);
        return student;
    }

    @Override
    public int addStu(Student student) {
        int i = studentMapper.addStudent(student);
        return i;
    }

    @Override
    public int updateStu(Student student) {
        int i = studentMapper.updateStudent(student);
        return i;
    }

    @Override
    public int deleteStuById(Integer sNo) {
        int i = studentMapper.deleteStudentById(sNo);
        return i;
    }

    @Override
    public List<SC> selectSCBySno(Integer sNo) {
        List<SC> scList = scMapper.selectSCBySno(sNo);
        return scList;
    }

    @Override
    public List<SC> selectSCByCno(Integer cNo) {
        List<SC> scList = scMapper.selectSCByCno(cNo);
        return scList;
    }

    @Override
    public int updateScore(Integer sNo, Integer cNo, Integer score) {
        SC sc = new SC(new Student(sNo), new Course(cNo), score);
        int i = scMapper.modifyScore(sc);
        return i;
    }

    @Override
    public List<Teacher> selectAllTeachers() {
        List<Teacher> teacherList = teacherMapper.selectAllTeachers();
        return teacherList;
    }

    @Override
    public Teacher selectTeacherById(Integer tNo) {
        Teacher teacher = teacherMapper.selectTeacherById(tNo);
        return teacher;
    }

    @Override
    public int addTeacher(Teacher teacher) {
        int i = teacherMapper.addTeacher(teacher);
        return i;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        int i = teacherMapper.updateTeacher(teacher);
        return i;
    }

    @Override
    public int deleteTeacher(Integer tNo) {
        int i = teacherMapper.deleteTeacherById(tNo);
        return i;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = userMapper.selectAllUsers();
        return users;
    }

    @Override
    public User selectUserById(Integer uid) {
        User user = userMapper.selectUserByUid(uid);
        return user;
    }

    @Override
    public User selectUserByUsername(String username) {
        User user = userMapper.selectUserByUsernameLogin(username);
        return user;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.addUserWithDetail(user);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateUserWithDetail(user);
        return i;
    }

    @Override
    public int deleteUser(Integer uid) {
        int i = userMapper.deleteUSerById(uid);
        return i;
    }


}
