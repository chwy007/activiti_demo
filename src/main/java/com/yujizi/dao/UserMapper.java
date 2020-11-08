package com.yujizi.dao;

import com.yujizi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.dao
 * @ClassName: UserMapper
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 17:20
 * @Version: 1.0
 */
public interface UserMapper {
    User findByID(Integer id);

    List<User> findAll();

    User findByName(String username);

    void insert(@Param("user") User user);
}
