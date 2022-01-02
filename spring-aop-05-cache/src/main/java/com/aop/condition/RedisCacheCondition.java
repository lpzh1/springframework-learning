package com.aop.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.data.redis.cache.RedisCacheManager;

public class RedisCacheCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean isEnableRedisCache = false;
        try {
            Class<?> aClass = Class.forName("org.springframework.data.redis.cache.RedisCacheManager");
            isEnableRedisCache = aClass.isAssignableFrom(RedisCacheManager.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
           return isEnableRedisCache;
        }
        return isEnableRedisCache;
    }

}
