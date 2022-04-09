package net.wei.website.mapper;

import net.wei.website.model.Admin;

public interface AdminMapper {
    int queryByUsernameAndPassword(Admin admin);
}
