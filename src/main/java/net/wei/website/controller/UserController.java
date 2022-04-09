package net.wei.website.controller;

import net.wei.website.model.User;
import net.wei.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String login1() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/regist")
    public String regist() {
        return "regist";
    }

    /**
     * 添加用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request) {
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setSex(sex);
        user.setAge(Integer.parseInt(age));
        user.setPhone(phone);
        user.setPassword(password);

        ModelAndView modelAndView = new ModelAndView();
        userService.add(user);

        modelAndView.setViewName("registSuccess");
        modelAndView.addObject(user);  // 添加成功后显示用户的信息
        return modelAndView;
    }

    @RequestMapping(value = "/registSuccess")
    public String registSuccess() {
        return "registSuccess";
    }

    @RequestMapping(value = "/loginSuccess")
    public String loginSuccess(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int row = userService.queryByUsernameAndPassword(username, password);
        if (row > 0) {
            return "loginSuccess";
        }
        return "loginError";
    }
}
