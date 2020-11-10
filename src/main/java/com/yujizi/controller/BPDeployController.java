package com.yujizi.controller;

import com.yujizi.pojo.User;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.controller
 * @ClassName: DeployController
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/10 13:26
 * @Version: 1.0
 */
@Controller
public class BPDeployController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @RequestMapping("deploy")
    @ResponseBody
    public String deploy(){
        repositoryService.createDeployment().addClasspathResource("bpmn/permsProcess.png").addClasspathResource("bpmn/permsProcess.bpmn").name("权限申请流程").category("oa").deploy();
        return "deploy success";
    }

    @RequestMapping("delDeploy")
    @ResponseBody
    public String delDeploy(String deploymentId){
        repositoryService.deleteDeployment(deploymentId);
        return "delete deploy success";
    }


}
