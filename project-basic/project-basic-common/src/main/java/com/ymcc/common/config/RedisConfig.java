package com.ymcc.common.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/28 22:14
 */
//缓存的配置
@Configuration
public class RedisConfig {

    @Resource
    private RedisConnectionFactory factory;


    //使用JSON进行序列化
    /*
    这个不像是黑马的Redis配置，这个是所有的数据结构类型都采用JSON结构存储
    而不是只有对象才采用JSON格式
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(factory);
        //JSON格式序列化
        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();
        //key的序列化
        redisTemplate.setKeySerializer(serializer);
        //value的序列化
        redisTemplate.setValueSerializer(serializer);
        //hash结构key的序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //hash结构value的序列化
        redisTemplate.setHashValueSerializer(serializer);
        return redisTemplate;
    }

}
