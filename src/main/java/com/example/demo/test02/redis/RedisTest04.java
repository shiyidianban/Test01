package com.example.demo.test02.redis;

import org.junit.Before;
import org.junit.Test;

/**
 * @author FLY
 * @date 2019-12-18 11:37
 */
public class RedisTest04 {

    RedisUtil redisUtil;

    /**
     * 初始化连接池
     */
    @Before
    public void init() {
        redisUtil = new RedisUtil();
    }

    @Test
    public void testRedis(){
        System.out.println(redisUtil.getValue("site-list"));
    }
}
