package com.edu.service;

import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.po.Student;

import java.util.List;
import java.util.Map;


public interface StudentService {

    /**
     * @Description 处理学生登录，登录成功返回该用户对象，失败返回null
     * @author maGuoWei
     * @date 2021/11/15 20:30
     * @param sNo: 学号
     * @param password: 密码
     * @return: com.edu.po.Student
     */
    Student studentLogin(Integer sNo,String password);

    /**
     * @Description 处理学生修改密码  1为修改成功   0为修改失败
     * @author maGuoWei
     * @date 2021/11/15 20:44
     * @param sNo: 学号
     * @param password: 密码
     * @return: int
     */
    int studentModifyPassword(Integer sNo,String password);

    /**
     * @Description 通过学号获取该学生成绩信息集合
     * @author maGuoWei
     * @date 2021/11/15 21:13
     * @param sNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> getSCListBySno(Integer sNo);


    /**
     * @Description 通过学号和课程号精确查询某学生某门课的成绩
     * @author maGuoWei
     * @date 2021/11/15 21:43
     * @param sNo:
     * @param cNo:
     * @return: com.edu.po.SC
     */
    SC getSCBySnoAndCno(Integer sNo,Integer cNo);


    /**
     * @Description 通过学号查询已选课列表
     * @author maGuoWei
     * @date 2021/11/16 23:07
     * @param sNo:
     * @return: java.util.List<com.edu.po.Course>
     */
    List<Course> getSelectCourseList(Integer sNo);


    /**
     * @Description 通过学号查询未选课列表
     * @author maGuoWei
     * @date 2021/11/17 21:26
     * @param sNo:
     * @return: java.util.List<com.edu.po.Course>
     */
    List<Course> getNotSelectCourseList(Integer sNo);


    /**
     * @Description 处理学生选课操作(同时插入成绩表，成绩默认为-1)
     * @author maGuoWei
     * @date 2021/11/17 22:03
     * @param sNo:
     * @param cNo:
     * @return: int
     */
    int selectCourse(Integer sNo,Integer cNo);


    /**
     * @Description 处理学生退课操作(同时删除成绩表中对应的记录)
     * @author maGuoWei
     * @date 2021/11/20 16:59
     * @param sNo:
     * @param cNo:
     * @return: int
     */
    int deleteSelectCourse(Integer sNo,Integer cNo);


}
