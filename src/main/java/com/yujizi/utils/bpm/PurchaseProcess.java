package com.yujizi.utils.bpm;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.utils.bpm
 * @ClassName: PurchaseProcess
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/5 20:14
 * @Version: 1.0
 */
public class PurchaseProcess {
    private ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

    @Test
    public void deploy(){
        /**
         * TODO
         * 部署
         * @ClassName PurchaseProcess
         * @author ychw
         * @date 2020/11/5 20:48
         */
        processEngine.getRepositoryService().createDeployment().addClasspathResource("PurchaseProcess.bpmn")
                .addClasspathResource("PurchaseProcess.png").name("采购流程").category("采购部").deploy();
    }


    @Test
    public void boot(){
        Map<String,Object> vars=new HashMap<>();
        vars.put("applyID","赵云");
        processEngine.getRuntimeService().startProcessInstanceByKey("purchaseBill",vars);
    }


    @Test
    public void queryTask(){
        String assignee="赵云";
        List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee(assignee).list();

        if(list!=null&&list.size()>0){
            for (Task task : list) {
                System.out.print(task.getId());
                System.out.print(task.getName());
                System.out.println(task.getAssignee());
            }
        }
        

    }

    @Test
    public void complete(){
        String taskID="7503";
        Map<String,Object> vars=new HashMap<>();
//        vars.put("presidentID","刘备");
//        vars.put("status",1);
        processEngine.getTaskService().complete(taskID,vars);


    }





}
