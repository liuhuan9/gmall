package com.atguigu.gmall.pms.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.UnknownHostException;

@Configuration
public class PmsRedisConfig {

    @Bean("redisTemplate")
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException{
        RedisTemplate<Object,Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);

        template.setDefaultSerializer(new GenericFastJsonRedisSerializer());

        return template;
    }
}
