import com.yujizi.dao.UserMapper;
import com.yujizi.pojo.User;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.utils.bpm
 * @ClassName: PurchaseProcess
 * @Author: ychw
 * @Description:
 * 分离出来activiti
 * 搞清楚spring test测试
 * @Date: 2020/11/5 20:14
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class PurchaseProcess {
    private ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = userMapper.findByID(1);
        System.out.println(user);


    }

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
