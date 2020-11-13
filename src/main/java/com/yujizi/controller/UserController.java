package com.yujizi.controller;

import com.yujizi.pojo.User;
import com.yujizi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.controller
 * @ClassName: UserController
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 17:24
 * @Version: 1.0
 */
@Controller

@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequiresRoles("staff")
    @RequestMapping("find/{id}")
    @ResponseBody
    public User findByID(@PathVariable Integer id) {
        return userService.findByID(id);

    }

//    @RequiresPermissions("second-level")
    @RequestMapping("all")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("register")
    @ResponseBody
    public String insert(String username,String password) {
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission("first-level");

        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleHash simpleHash = new SimpleHash("MD5", password, salt, 3);
        User user = new User();
        user.setUsername(username);
        user.setPassword(simpleHash.toString());

        userService.insert(user);
        return "success";
    }

}
