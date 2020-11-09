package com.yujizi.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.pojo
 * @ClassName: User
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 17:18
 * @Version: 1.0
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;

}
