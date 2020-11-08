package com.yujizi.service;

import com.yujizi.dao.UserMapper;
import com.yujizi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.service
 * @ClassName: UserServiceImpl
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 17:25
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByID(Integer id) {
        return userMapper.findByID(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
