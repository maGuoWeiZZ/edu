package com.edu.dao;

import com.edu.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    /**
     * @Description 查询所有学生信息
     * @author maGuoWei
     * @date 2021/10/12 19:18
     * @return: java.util.List<com.edu.po.Student>
     */
    List<Student> selectAllStudents();

    /**
     * @Description 根据学号sNo精确查询学生信息
     * @author maGuoWei
     * @date 2021/10/12 19:24
     * @param sNo:
     * @return: com.edu.po.Student
     */
    Student selectStudentById(Integer sNo);

    /**
     * @Description 根据学号和密码查询学生信息
     * @author maGuoWei
     * @date 2021/11/15 23:28
     * @param sNo:
     * @param sPassword:
     * @return: com.edu.po.Student
     */
    Student selectStudentByIdAndPassword(@Param("sNo") Integer sNo, @Param("sPassword") String sPassword);


    /**
     * @Description 根据集合中的id批量查询学生信息
     * @author maGuoWei
     * @date 2021/10/30 11:11
     * @param list:
     * @return: java.util.List<com.edu.po.Student>
     */
    List<Student> selectStudentByIds(List<Integer> list);

    /**
     * @Description 根据姓名模糊查询学生信息
     * @author maGuoWei
     * @date 2021/10/12 19:28
     * @param sName:
     * @return: java.util.List<com.edu.po.Student>
     */
    List<Student> selectStudentByName(String sName);

    /**
     * @Description 添加学生信息
     * @author maGuoWei
     * @date 2021/10/12 19:33
     * @param student:
     * @return: int
     */
    int addStudent(Student student);

    /**
     * @Description 批量添加学生信息
     * @author maGuoWei
     * @date 2021/11/13 10:11
     * @param students:
     * @return: int
     */
    int addStudents(List<Student> students);

    /**
     * @Description 修改学生信息
     * @author maGuoWei
     * @date 2021/10/12 19:39
     * @param student:
     * @return: int
     */
    int updateStudent(Student student);

    /**
     * @Description 根据学号sNo删除学生信息
     * @author maGuoWei
     * @date 2021/10/12 19:42
     * @param sNo:
     * @return: int
     */
    int deleteStudentById(Integer sNo);

}
