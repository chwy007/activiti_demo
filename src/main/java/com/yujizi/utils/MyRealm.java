package com.yujizi.utils;

import com.yujizi.dao.UserMapper;
import com.yujizi.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: activiti_demo
 * @Package: com.yujizi.utils
 * @ClassName: MyRealm
 * @Author: ychw
 * @Description:
 * @Date: 2020/11/8 11:30
 * @Version: 1.0
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("second-level");
        info.addRole("staff");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userMapper.findByName(username);

        if(user!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
            info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()));
            return info;
        }

        return null;
    }
}
