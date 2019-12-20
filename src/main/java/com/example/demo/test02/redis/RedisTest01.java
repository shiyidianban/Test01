package com.example.demo.test02.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author FLY
 * @CreateDate 2019-12-18 10:31
 * @ProjectName Test01
 * @Desc 使用SpringBoot连接redis
 */
@Component
public class RedisTest01 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取数据
     */
    public void getStringRedisTemplate(){
        String value = stringRedisTemplate.opsForValue().get("str1");
        System.out.println(value);
    }

    /**
     * 放入数据
     */
    public void setStringRedisTemplate(){
        stringRedisTemplate.opsForValue().set("str1","ttttt",10, TimeUnit.SECONDS);
        System.out.println("添加成功");
    }

    public void getRedisTemplate(){
        String value = (String)redisTemplate.opsForValue().get("str2");
        System.out.println(value);
    }

    public void setRedisTemplate(){
        redisTemplate.opsForValue().set("str2","ttttt",10, TimeUnit.SECONDS);
        System.out.println("添加成功");
    }

}
