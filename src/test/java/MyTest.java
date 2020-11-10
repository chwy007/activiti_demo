import com.yujizi.dao.UserMapper;
import com.yujizi.pojo.User;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
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
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MyTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired


    @Test
    public void test1(){
        User user = userMapper.findByID(1);
        System.out.println(user);

    }







}
