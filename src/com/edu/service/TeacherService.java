package com.edu.service;

import com.edu.po.SC;
import com.edu.po.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * @Description 通过教师编号和密码进行登录，成功返回教师对象，失败返回null
     * @author maGuoWei
     * @date 2021/11/20 14:30
     * @param tNo:
     * @param password:
     * @return: com.edu.po.Teacher
     */
    Teacher teacherLogin(Integer tNo,String password);

    /**
     * @Description 修改教师密码，成功返回1 失败返回0
     * @author maGuoWei
     * @date 2021/11/20 18:28
     * @param tNo:
     * @param password:
     * @return: int
     */
    int teacherModifyPassword(Integer tNo,String password);

    /**
     * @Description 通过学号查询学生所有成绩信息
     * @author maGuoWei
     * @date 2021/11/20 18:52
     * @param sNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectScoreBySno(Integer sNo);


    /**
     * @Description 通过课程号查询该门课程的所有学生成绩信息
     * @author maGuoWei
     * @date 2021/11/20 19:09
     * @param cNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectScoreByCno(Integer cNo);

    /**
     * @Description 通过课程号查询该门课程的所有学生成绩信息并按照成绩排名
     * @author maGuoWei
     * @date 2021/11/27 16:14
     * @param cNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectScoreByCnoOrderByScore(Integer cNo);

    /**
     * @Description 通过学号、课程号、成绩 录入成绩
     * @author maGuoWei
     * @date 2021/11/20 19:52
     * @param sNo:
     * @param cNo:
     * @param score:
     * @return: int
     */
    int inputScore(Integer sNo,Integer cNo,Integer score);



}
