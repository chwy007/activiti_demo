import com.yujizi.dao.UserMapper;
import com.yujizi.pojo.User;
import org.apache.shiro.cas.CasSubjectFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-redis.xml"})
public class MyTest {
    public static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1(){

        logger.info("***********************hello============");
        User user = userMapper.findByID(1);
        System.out.println(user);

    }


    @Test
    public void test2(){
        User user = userMapper.findByID(1);
        redisTemplate.opsForValue().set("user1",user.toString());
        redisTemplate.opsForHash().put("role1","name","张飞");
        redisTemplate.opsForHash().put("role1","age",15);
        redisTemplate.opsForHash().put("role1","性别","男");
        Map<String,Object> map=new HashMap<>();
        map.put("name","刘备");
        map.put("age","16");
        map.put("性别","男");
        redisTemplate.opsForHash().putAll("role2",map);

    }


    @Test
    public void test3(){
        logger.info(redisTemplate.opsForHash().get("role2","name").toString());
        logger.info(redisTemplate.opsForValue().get("96b390cd-bdc6-4fce-8c5a-e3b0efdad669").toString());
        HttpServletRequest httpServletRequest;

    }










}
