package com.edu.dao;

import com.edu.po.SC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SCMapper {

    /**
     * @Description 查询所有成绩信息
     * @author maGuoWei
     * @date 2021/10/12 21:06
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectAllSC();

    /**
     * @Description 通过学号sNo查询成绩（成绩单）
     * @author maGuoWei
     * @date 2021/10/12 21:10
     * @param sNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectSCBySno(Integer sNo);

    /**
     * @Description 通过课程号cNo查询成绩（某门课程所有学生成绩）
     * @author maGuoWei
     * @date 2021/10/12 21:15
     * @param cNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectSCByCno(Integer cNo);

    /**
     * @Description 通过课程号查询该门课程的所有学生成绩信息并按照成绩排名
     * @author maGuoWei
     * @date 2021/11/27 16:15
     * @param cNo:
     * @return: java.util.List<com.edu.po.SC>
     */
    List<SC> selectSCByCnoOrderByScore(Integer cNo);

    /**
     * @Description 通过学号和课程号查询成绩（具体某学生某门课程的成绩）
     * @author maGuoWei
     * @date 2021/10/12 21:37
     * @param sNo:
     * @param cNo:
     * @return: com.edu.po.SC
     */
    SC selectSCBySnoAndCno(@Param("sNo") Integer sNo,@Param("cNo") Integer cNo);


    /**
     * @Description 添加成绩信息
     * @author maGuoWei
     * @date 2021/10/12 21:24
     * @param sc:
     * @return: int
     */
    int addSC(SC sc);

    /**
     * @Description 通过成绩编号删除成绩
     * @author maGuoWei
     * @date 2021/10/12 21:28
     * @param scId:
     * @return: int
     */
    int deleteSCBySCId(Integer scId);

    /**
     * @Description 通过学号和课程号删除成绩
     * @author maGuoWei
     * @date 2021/11/20 17:23
     * @param sNo:
     * @param cNo:
     * @return: int
     */
    int deleteSCBySnoAndCno(@Param("sNo") Integer sNo,@Param("cNo") Integer cNo);

    /**
     * @Description 修改成绩
     * @author maGuoWei
     * @date 2021/10/12 21:32
     * @param sc:
     * @return: int
     */
    int modifyScore(SC sc);

}
