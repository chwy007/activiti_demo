package com.yujizi.sessiondao;

import com.hazelcast.util.UuidUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.net.CookieManager;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ychw
 * @Description:
 * @Date: 2020/12/5 21:39
 */
public class RedisSessionDao extends EnterpriseCacheSessionDAO {
    protected static final Logger logger= LoggerFactory.getLogger(RedisSessionDao.class);
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        logger.debug("doCreate session ******************************************");

        Serializable sessionId = super.doCreate(session);
        redisTemplate.opsForValue().set(sessionId.toString(),session,18, TimeUnit.HOURS);
        return sessionId;







    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.info("doReadSession session  **********************************");

        Session session=super.doReadSession(sessionId);

        if(session == null){
            session=(Session)this.redisTemplate.opsForValue().get(sessionId.toString());
            logger.debug("redis中查出来的session:"+session);
            return session;
        }

        return null;
    }

    @Override
    protected void doUpdate(Session session) {
        logger.info("doUpdate session  ******************************************");

            super.doUpdate(session);
            this.redisTemplate.opsForValue().set(session.getId().toString(),session,18,TimeUnit.HOURS);

    }

    @Override
    protected void doDelete(Session session) {
        logger.info("doDelete session  *******************************************");
        super.doDelete(session);
        this.redisTemplate.delete(session.getId().toString());
    }




}
