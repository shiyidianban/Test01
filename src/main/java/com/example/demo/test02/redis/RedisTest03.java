package com.example.demo.test02.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 连接池配置
 *
 * @author FLY
 * @date 2019-12-18 10:58
 */
public class RedisTest03 {

    JedisPool pool;

    /**
     * 初始化连接池
     */
    @Before
    public void init() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        pool = new JedisPool(jedisPoolConfig, "localhost");
        System.out.println("连接池初始化成功");
    }

    @Test
    public void testPing() {
        // Jedis 实现了java.lang.AutoCloseable接口,所以这里可以用java 1.7 try-with-resources语法自动完成close
        try (Jedis jedis = pool.getResource()) {
            //查看服务是否运行 PING
            System.out.println("服务正在运行: " + jedis.ping());
        }
    }

    @Test
    public void testString() {
        try (Jedis jedis = pool.getResource()) {
            //设置 redis 字符串数据 SET 10km blog.csdn.net/10km
            jedis.set("10km", "blog.csdn.net/10km");
            // 获取存储的数据并输出
            System.out.println("redis 存储的字符串为: " + jedis.get("10km"));
        }
    }
}
