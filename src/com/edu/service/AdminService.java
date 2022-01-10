package com.edu.service;

import com.edu.po.SC;
import com.edu.po.Student;
import com.edu.po.Teacher;
import com.edu.po.User;

import java.util.List;

public interface AdminService {

    /**
     * @Description 管理员登录
     * @author maGuoWei
     * @date 2021/11/27 17:25
     * @param username:
     * @param password:
     * @return: com.edu.po.User
     */
    User adminLogin(String username,String password);

    /**
     * @Description 修改管理员密码
     * @author maGuoWei
     * @date 2021/11/27 17:53
     * @param uid: 
     * @param password:
     * @return: int
     */
    int modifyPwd(Integer uid,String password);

    /**
     * @Description 查询所有学生信息
     * @author maGuoWei
     * @date 2021/11/27 18:39
     * @return: java.util.List<com.edu.po.Student>
     */
    List<Student> selectAllStu();

    /**
     * @Description 根据学号查询学生信息
     * @author maGuoWei
     * @date 2021/11/27 18:56
     * @param sNo:
     * @return: com.edu.po.Student
     */
    Student selectStuBySno(Integer sNo);

    /**
     * @Description 添加学生信息
     * @author maGuoWei
     * @date 2021/11/27 19:37
     * @param student:
     * @return: int
     */
    int addStu(Student student);

    /**
     * @Description 修改学生信息
     * @author maGuoWei
     * @date 2021/12/8 9:44
     * @param student:
     * @return: int
     */
    int updateStu(Student student);

    /**
     * @Description 通过学号删除学生信息
     * @author maGuoWei
     * @date 2021/12/8 19:46
     * @param sNo:
     * @return: int
     */
    int deleteStuById(Integer sNo);

    /**
     * @Description 按学号查询学生成绩
     * @author maGuoWei
     * @date 2021/12/8 20:08
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectSCBySno(Integer sNo);

    /**
     * @Description 按课程号查询学生成绩
     * @author maGuoWei
     * @date 2021/12/8 20:58
     * @param cNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectSCByCno(Integer cNo);

    /**
     * @Description 修改学生成绩
     * @author maGuoWei
     * @date 2021/12/8 20:37
     * @param sNo:
     * @param cNo:
     * @param score:
     * @return: int
     */
    int updateScore(Integer sNo,Integer cNo,Integer score);

    /**
     * @Description 查询所有教师信息
     * @author maGuoWei
     * @date 2021/12/8 21:17
     * @return: java.util.List<com.edu.po.Teacher>
     */
    List<Teacher> selectAllTeachers();

    /**
     * @Description 通过教师编号查询教师信息
     * @author maGuoWei
     * @date 2021/12/8 21:33
     * @param tNo:
     * @return: com.edu.po.Teacher
     */
    Teacher selectTeacherById(Integer tNo);

    /**
     * @Description 添加教师信息
     * @author maGuoWei
     * @date 2021/12/8 21:49
     * @param teacher:
     * @return: int
     */
    int addTeacher(Teacher teacher);

    /**
     * @Description 修改教师信息
     * @author maGuoWei
     * @date 2021/12/8 22:18
     * @param teacher:
     * @return: int
     */
    int updateTeacher(Teacher teacher);

    /**
     * @Description 通过教师编号删除教师信息
     * @author maGuoWei
     * @date 2021/12/9 17:46
     * @param tNo:
     * @return: int
     */
    int deleteTeacher(Integer tNo);

    /**
     * @Description 查询所有管理员信息
     * @author maGuoWei
     * @date 2021/12/9 18:29
     * @return: java.util.List<com.edu.po.User>
     */
    List<User> selectAllUsers();

    /**
     * @Description 按uid查询管理员信息
     * @author maGuoWei
     * @date 2021/12/9 19:00
     * @param uid:
     * @return: com.edu.po.User
     */
    User selectUserById(Integer uid);

    /**
     * @Description 按用户名查询管理员信息
     * @author maGuoWei
     * @date 2021/12/9 20:12
     * @param username:
     * @return: com.edu.po.User
     */
    User selectUserByUsername(String username);

    /**
     * @Description 添加管理员信息
     * @author maGuoWei
     * @date 2021/12/9 19:20
     * @param user:
     * @return: int
     */
    int addUser(User user);

    /**
     * @Description 修改管理员信息
     * @author maGuoWei
     * @date 2021/12/9 20:50
     * @param user:
     * @return: int
     */
    int updateUser(User user);

    /**
     * @Description 通过管理员编号删除管理员信息
     * @author maGuoWei
     * @date 2021/12/9 22:57
     * @param uid:
     * @return: int
     */
    int deleteUser(Integer uid);

}
