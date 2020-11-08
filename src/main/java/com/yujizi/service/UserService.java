package com.yujizi.service;

import com.yujizi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.service
 * @ClassName: UserService
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 17:25
 * @Version: 1.0
 */
public interface UserService {
    User findByID(Integer id);
    List<User> findAll();
    void insert(User user);
}
