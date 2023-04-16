package com.javanoteany.common.shiro.session;

import com.javanoteany.common.constant.ShiroConstant;
import com.javanoteany.common.context.ContextUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class RedisCacheSessionDao extends CachingSessionDAO {

    @Resource(name = "redisTemplate")
    private ValueOperations<Serializable, Session> valueOperations;

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheSessionDao.class);

    @Override
    protected void doUpdate(Session session) {
        valueOperations.set(ShiroConstant.PREFIX + session.getId(),session,ShiroConstant.TIME_OUT, TimeUnit.SECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        valueOperations.getOperations().delete(session.getId());
    }

    @Override
    protected Serializable doCreate(Session session) {
        HttpServletRequest request = ContextUtils.getRequest();
        String sessionId = request.getSession().getId();
        assignSessionId(session,sessionId);
        valueOperations.set(ShiroConstant.PREFIX + sessionId,session,ShiroConstant.TIME_OUT, TimeUnit.SECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        Session session = valueOperations.get(ShiroConstant.PREFIX + serializable);
        return session;
    }
}
