package net.wei.website.service;

import net.wei.website.model.User;

import java.util.List;

public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    void add(User user);

    /**
     * 登录时验证用户名和密码
     * @param username
     * @param password
     * @return
     */
    int queryByUsernameAndPassword(String username, String password);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> queryAllUsers();
}
