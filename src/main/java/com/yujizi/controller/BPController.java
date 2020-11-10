package com.yujizi.controller;

import com.yujizi.pojo.User;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.controller
 * @ClassName: ProcessController
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/10 10:57
 * @Version: 1.0
 */
@Controller
public class BPController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @RequestMapping("apply")
    @ResponseBody
    public String apply(String permission){
        User loginUser = (User) SecurityUtils.getSubject().getSession().getAttribute("loginUser");
        String assignee=loginUser.getUsername();
        Map<String,Object> vars=new HashMap<>();
        vars.put("permission",permission);
        vars.put("applicant",assignee);
        runtimeService.startProcessInstanceByKey("permsBill",vars);
        List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).list();
        if(list!=null&&list.size()>0){
            for (Task task : list) {
                System.out.print(task.getId());
                System.out.print(task.getName());
                System.out.println(task.getAssignee());

                taskService.setVariable(task.getId(),"manager","kate");
                taskService.complete(task.getId());
            }
        }

        return "application commited";
    }

    @RequestMapping("handle")
    @ResponseBody
    public String handle(){
        User loginUser = (User) SecurityUtils.getSubject().getSession().getAttribute("loginUser");
        String assignee=loginUser.getUsername();
        List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).list();
        if(list!=null&&list.size()>0){
            for (Task task : list) {
                System.out.print(task.getId());
                System.out.print(task.getName());
                System.out.println(task.getAssignee());
                taskService.setVariable(task.getId(),"status",1);
                taskService.complete(task.getId());
            }
        }
        return "complete all";
    }


    @RequestMapping("handle1")
    @ResponseBody
    public String handle1(){
//        runtimeService.setVariable("2503","status",0);
//        runtimeService.setVariable("2503","presidentID","bbb");
        taskService.complete("25003");
        return "clear";
    }

}
