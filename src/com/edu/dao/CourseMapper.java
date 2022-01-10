package com.edu.dao;

import com.edu.po.Course;

import java.util.List;

public interface CourseMapper {

    /**
     * @Description 查询所有课程信息
     * @author maGuoWei
     * @date 2021/11/13 10:30
     * @return: java.util.List<com.edu.po.Course>
     */
    List<Course> selectAllCourse();

    /**
     * @Description 通过课程编号精确查询课程信息
     * @author maGuoWei
     * @date 2021/11/13 10:36
     * @param cNo:
     * @return: com.edu.po.Course
     */
    Course selectCourseById(Integer cNo);

    /**
     * @Description 通过课程名称模糊查询课程信息
     * @author maGuoWei
     * @date 2021/11/13 10:41
     * @param cName:
     * @return: java.util.List<com.edu.po.Course>
     */
    List<Course> selectCourseByName(String cName);

    /**
     * @Description 添加课程信息
     * @author maGuoWei
     * @date 2021/11/13 10:43
     * @param course:
     * @return: int
     */
    int addCourse(Course course);

    /**
     * @Description 通过课程编号删除课程信息
     * @author maGuoWei
     * @date 2021/11/13 10:59
     * @param cNo:
     * @return: int
     */
    int deleteCourseById(Integer cNo);

    /**
     * @Description 修改课程信息
     * @author maGuoWei
     * @date 2021/11/13 11:01
     * @param course:
     * @return: int
     */
    int updateCourse(Course course);



}
