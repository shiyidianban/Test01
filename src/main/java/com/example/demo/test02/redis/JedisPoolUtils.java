package com.example.demo.test02.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author FLY
 * @CreateDate 2019-12-18 14:29
 * @ProjectName Test01
 * @Desc
 */
public class JedisPoolUtils {

    private static JedisPool pool;

    static {
        //加载配置文件
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获得池子对象
        JedisPoolConfig poolconfig = new JedisPoolConfig();
        poolconfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));//最大闲置个数
        poolconfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));//最小闲置个数
        poolconfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));//最大连接数
        pool = new JedisPool(poolconfig,pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));

    }
}
