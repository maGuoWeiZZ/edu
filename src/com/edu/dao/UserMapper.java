package com.edu.dao;

import com.edu.po.User;

import java.util.List;

public interface UserMapper {

    /**
     * @Description 查询所有用户信息
     * @author maGuoWei
     * @date 2021/10/12 20:30
     * @return: java.util.List<com.edu.po.User>
     */
    List<User> selectAllUsers();

    /**
     * @Description 按uid查询管理员信息
     * @author maGuoWei
     * @date 2021/12/9 19:05
     * @param uid:
     * @return: com.edu.po.User
     */
    User selectUserByUid(Integer uid);

    /**
     * @Description 通过用户名模糊查询用户信息
     * @author maGuoWei
     * @date 2021/10/12 20:37
     * @param username:
     * @return: com.edu.po.User
     */
    User selectUserByUsername(String username);

    /**
     * @Description 通过用户名精确查询用户信息
     * @author maGuoWei
     * @date 2021/12/9 18:49
     * @param username:
     * @return: com.edu.po.User
     */
    User selectUserByUsernameLogin(String username);

    /**
     * @Description 通过uid查询用户详细信息(嵌套结果)
     * @author maGuoWei
     * @date 2021/11/13 9:30
     * @param uid:
     * @return: com.edu.po.User
     */
    User selectUserWithDetailByIdResult(Integer uid);

    /**
     * @Description 通过uid查询用户详细信息(嵌套查询，延迟加载)
     * @author maGuoWei
     * @date 2021/11/13 9:31
     * @param uid:
     * @return: com.edu.po.User
     */
    User selectUserWithDetailByIdQuery(Integer uid);

    /**
     * @Description 添加用户(包括详细信息)
     * @author maGuoWei
     * @date 2021/11/13 9:44
     * @param user:
     * @return: int
     */
    int addUserWithDetail(User user);

    /**
     * @Description 通过uid删除用户信息(包括详细信息)
     * @author maGuoWei
     * @date 2021/11/13 9:47
     * @param uid:
     * @return: int
     */
    int deleteUSerById(Integer uid);

    /**
     * @Description 修改用户信息(包括详细信息)
     * @author maGuoWei
     * @date 2021/11/13 9:52
     * @param user:
     * @return: int
     */
    int updateUserWithDetail(User user);


}
