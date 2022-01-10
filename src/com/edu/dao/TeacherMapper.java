package com.edu.dao;

import com.edu.po.Teacher;

import java.util.List;

public interface TeacherMapper {

    /**
     * @Description 查询所有教师信息
     * @author maGuoWei
     * @date 2021/10/12 19:49
     * @return: java.util.List<com.edu.po.Teacher>
     */
    List<Teacher> selectAllTeachers();

    /**
     * @Description 通过教师姓名模糊查询
     * @author maGuoWei
     * @date 2021/10/12 19:56
     * @param tName:
     * @return: java.util.List<com.edu.po.Teacher>
     */
    List<Teacher> selectTeacherByName(String tName);

    /**
     * @Description 通过教师编号查询教师信息
     * @author maGuoWei
     * @date 2021/10/12 20:05
     * @param tNo:
     * @return: com.edu.po.Teacher
     */
    Teacher selectTeacherById(Integer tNo);

    /**
     * @Description 添加教师信息
     * @author maGuoWei
     * @date 2021/10/12 20:13
     * @param teacher:
     * @return: int
     */
    int addTeacher(Teacher teacher);

    /**
     * @Description 根据教师编号删除教师信息
     * @author maGuoWei
     * @date 2021/10/12 20:15
     * @param tNo:
     * @return: int
     */
    int deleteTeacherById(Integer tNo);

    /**
     * @Description 修改教师信息
     * @author maGuoWei
     * @date 2021/11/15 16:09
     * @param teacher:
     * @return: int
     */
    int updateTeacher(Teacher teacher);

}
