package com.edu.test;

import com.edu.dao.UserMapper;
import com.edu.po.User;
import com.edu.po.UserDetail;
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
 * @Description User测试类
 * @date 2021/10/2 19:20
 */
public class UserTest {

//    查询所有用户信息
    @Test
    public void selectAllUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

//    通过用户名模糊查询用户信息
    @Test
    public void selectUserByUsername() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByUsername("ad");
        System.out.println(user);
        sqlSession.close();
    }

    //    嵌套结果
    @Test
    public void selectUserWithDetailByIdResult() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserWithDetailByIdResult(1);
        System.out.println(user);
        sqlSession.close();
    }

    //    嵌套查询，延迟加载
    @Test
    public void selectUserWithDetailByIdQuery() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserWithDetailByIdQuery(1);
        System.out.println(user.getUsername());
        sqlSession.close();
    }

    //    插入用户，调用存储过程
    @Test
    public void addUserWithDetail() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("test1234", "abcv456", new UserDetail("张六", "8912376@qq.com", "13309334587"));
        int i = mapper.addUserWithDetail(user);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        System.out.println(user.getUid());
        sqlSession.close();
    }


    //    级联删除
    @Test
    public void deleteUSerById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUSerById(10);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.close();
    }

    //    级联更新
    @Test
    public void updateUserWithDetail() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(2, null, "9624586", null);
        UserDetail detail = new UserDetail("马国伟", "15379181601@163.com", "15379181601");
        user.setDetail(detail);
        int i = mapper.updateUserWithDetail(user);
        sqlSession.commit();
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sqlSession.close();
    }

}
