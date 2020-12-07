package com.yujizi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.controller
 * @ClassName: LoginController
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 17:30
 * @Version: 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("bye")
    public String bye(){
        return "bye";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("unauthorize")
    public String unauthorize(){
        return "unauthorize";
    }




}
