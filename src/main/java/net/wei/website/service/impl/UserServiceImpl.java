package net.wei.website.service.impl;

import net.wei.website.mapper.UserMapper;
import net.wei.website.model.User;
import net.wei.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public int queryByUsernameAndPassword(String username, String password) {
        int row = userMapper.queryByUsernameAndPassword(username, password);
        return row;
    }

    @Override
    public List<User> queryAllUsers() {
        List<User> users = userMapper.queryAllUsers();
        return users;
    }
}
