package com.edu.test;

import com.edu.dao.SCMapper;
import com.edu.po.Course;
import com.edu.po.SC;
import com.edu.po.Student;
import com.edu.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * @author maGuoWei
 * @Description SC测试类
 * @date 2021/10/3 16:41
 */
public class SCTest {

    //    查询所有成绩信息
    @Test
    public void selectAllSC() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        List<SC> list = mapper.selectAllSC();
        for (SC sc : list) {
            System.out.println(sc.getStudent().getsName() + " " + sc.getCourse().getcName() + " " + sc.getScore());
        }
        sqlSession.close();
    }

    //    通过学号查询成绩
    @Test
    public void selectSCBySno() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        List<SC> list = mapper.selectSCBySno(1);
        for (SC sc : list) {
            System.out.println(sc);
            System.out.println(sc.getStudent().getsName() + " " + sc.getCourse().getcName() + " " + sc.getScore());
        }
        sqlSession.close();
    }

    //    通过课程号cNo查询成绩
    @Test
    public void selectSCByCno() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        List<SC> list = mapper.selectSCByCno(1);
        for (SC sc : list) {
            System.out.println(sc);
            System.out.println(sc.getStudent().getsName() + " " + sc.getCourse().getcName() + " " + sc.getScore());
        }
        sqlSession.close();
    }

    //    通过课程号cNo查询成绩并排序
    @Test
    public void selectSCByCnoOrderByScore() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        List<SC> list = mapper.selectSCByCnoOrderByScore(1);
        for (SC sc : list) {
            System.out.println(sc.getStudent().getsName());
        }
        sqlSession.close();
    }

    //    通过学号和课程号查询成绩
    @Test
    public void selectSCBySnoAndCno() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        SC sc = mapper.selectSCBySnoAndCno(1, 2);
        System.out.println(sc);
        System.out.println(sc.getStudent().getsName() + " " + sc.getCourse().getcName() + " " + sc.getScore());
        sqlSession.close();
    }

    //    添加成绩信息
    @Test
    public void addSC() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        SC sc = new SC();
        sc.setScore(100);
        sc.setStudent(new Student(1));
        sc.setCourse(new Course(3));
        int i = mapper.addSC(sc);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        System.out.println(sc.getScId());
        sqlSession.close();
    }

    //    通过成绩编号删除成绩
    @Test
    public void deleteSCBySCId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        SC sc = new SC(6);
        int i = mapper.deleteSCBySCId(sc.getScId());
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.close();
    }

    @Test
    public void deleteSCBySnoAndCno(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        int i = mapper.deleteSCBySnoAndCno(1, 1);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        sqlSession.close();
    }

    //    修改成绩
    @Test
    public void modifyScore() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SCMapper mapper = sqlSession.getMapper(SCMapper.class);
        SC sc = new SC(1, new Student(1), new Course(1), 95);
        int i = mapper.modifyScore(sc);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sqlSession.close();
    }

}
