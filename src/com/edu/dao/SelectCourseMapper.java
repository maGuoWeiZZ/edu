package com.edu.dao;

import com.edu.po.Course;
import com.edu.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCourseMapper {

    /**
     * @Description 按学号查询选课信息
     * @author maGuoWei
     * @date 2021/10/11 20:59
     * @param sNo:
     * @return: java.util.List<com.edu.po.Course>
     */
    List<Course> selectSelectCourseBySNo(Integer sNo);

    /**
     * @Description 按课程号查询选课信息
     * @author maGuoWei
     * @date 2021/10/11 20:59
     * @param cNo:
     * @return: java.util.List<com.edu.po.Student>
     */
    List<Student> selectSelectCourseByCNo(Integer cNo);


    /**
     * @Description 按学号查询未选课信息
     * @author maGuoWei
     * @date 2021/11/17 21:23
     * @param sNo:
     * @return: java.util.List<com.edu.po.Course>
     */
    List<Course> selectNotSelectCourseBySNo(Integer sNo);


    /**
     * @Description 添加选课信息(使用存储过程顺便插入成绩表，成绩为默认为-1)
     * @author maGuoWei
     * @date 2021/10/11 21:00
     * @param sNo:
     * @param cNo:
     * @return: int
     */
    int addSelectCourse(@Param("sNo") Integer sNo, @Param("cNo") Integer cNo);

    /**
     * @Description 根据学号和课程号删除选课信息
     * @author maGuoWei
     * @date 2021/10/11 21:03
     * @param sNo:
     * @param cNo:
     * @return: int
     */
    int deleteSelectCourseBySnoAndCno(@Param("sNo") Integer sNo, @Param("cNo") Integer cNo);

}
