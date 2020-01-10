package com.example.demo;

import com.example.demo.test02.redis.RedisTest01;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author FLY
 * @date 2019-12-18 10:19
 Redis基本练习，需要启动Springboot从配置文件中获取redis连接
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTest01 redisTest01;

    @Test
    public void getStringRedisTemplate(){
        redisTest01.getStringRedisTemplate();
    }

    @Test
    public void setStringRedisTemplate(){
        redisTest01.setStringRedisTemplate();
    }

    @Test
    public void getRedisTemplate(){
        redisTest01.getRedisTemplate();
    }

    @Test
    public void setRedisTemplate(){
        redisTest01.setRedisTemplate();
    }
}
