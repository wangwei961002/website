package net.wei.website.service;

import net.wei.website.model.Admin;

public interface AdminService {
    Integer queryByUsernameAndPassword(Admin admin);
}
