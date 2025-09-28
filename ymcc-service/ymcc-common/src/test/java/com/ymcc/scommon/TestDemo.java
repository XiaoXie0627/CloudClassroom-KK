package com.ymcc.scommon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/28 22:34
 */
@SpringBootTest(classes = ServiceCommon.class)
@RunWith(SpringRunner.class)
public class TestDemo {
    @Autowired
    public RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name","xhh");
    }
}
