package net.wei.website.service.impl;

import net.wei.website.mapper.AdminMapper;
import net.wei.website.model.Admin;
import net.wei.website.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Integer queryByUsernameAndPassword(Admin admin) {

        int row = adminMapper.queryByUsernameAndPassword(admin);

        return row;
    }
}
