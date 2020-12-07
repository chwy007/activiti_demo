package com.yujizi.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;


import java.util.List;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/4 0:38
 */
public class MyCasRealm extends CasRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("正在为主体认证====================================");
        CasToken casToken=(CasToken)token;

        if(casToken == null){
            System.out.println("casToken为空");
            return null;
        }

        String ticket= (String) casToken.getCredentials();

        if(!StringUtils.hasText(ticket)){
            System.out.println("ticket为空");
            return null;
        }
        System.out.println(ticket+"=====================");
        TicketValidator ticketValidator=super.createTicketValidator();
        try {
            Assertion assertion = ticketValidator.validate(ticket, super.getCasService());
            AttributePrincipal principal = assertion.getPrincipal();
            String name = principal.getName();
            System.out.println("正在认证的主体为"+name);
            List principals = CollectionUtils.asList(name, principal.getAttributes());
            PrincipalCollection principalCollection=new SimplePrincipalCollection(principals,super.getName());

            return new SimpleAuthenticationInfo(principalCollection,ticket);


        } catch (TicketValidationException e) {
            System.out.println("认证失败");
            e.printStackTrace();
            return null;
        }


    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("正在为主体授权====================================");
        String username=(String)principals.getPrimaryPrincipal();
        System.out.println("================认证后的主体为"+username);
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("second-level");
        info.addStringPermission("first-level");
        info.addRole("manager");
//        info.addRole("staff");
        return info;


    }
}
