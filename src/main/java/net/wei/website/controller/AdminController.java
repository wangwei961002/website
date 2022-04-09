package net.wei.website.controller;

import net.wei.website.model.Admin;
import net.wei.website.model.User;
import net.wei.website.service.AdminService;
import net.wei.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "adminLogin";
    }

    @PostMapping("/loginSuccessOrFail")
    public String loginSuccessOrFail(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        Integer row = adminService.queryByUsernameAndPassword(admin);
        if (row > 0) {  // 管理员登录成功，则显示所有的用户成员
            List<User> users = userService.queryAllUsers();
            model.addAttribute("users",users);
            return "adminLoginSuccess";
        }
        return "adminLoginFail";
    }
}
