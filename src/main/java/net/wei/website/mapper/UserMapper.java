package net.wei.website.mapper;

import net.wei.website.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    void add(User user);

    int queryByUsernameAndPassword(@Param(value = "username") String username,
                                   @Param(value = "password") String password);

    List<User> queryAllUsers();
}
