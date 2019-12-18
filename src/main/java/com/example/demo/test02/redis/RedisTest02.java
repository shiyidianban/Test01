package com.example.demo.test02.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author FLY
 * @CreateDate 2019-12-18 10:36
 * @ProjectName Test01
 * @Desc java本地连接redis
 */
public class RedisTest02 {

    Jedis jedis;

    @Before
    public void setRedis(){
        //连接本地的 Redis 服务
        jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println(jedis.ping());
    }

    /**
     * 获取所有数据
     */
    @Test
    public void getAll(){
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(String.format("%s : %s",key,jedis.type(key)));
        }
    }

    /**
     * 设置String字符串
     */
    @Test
    public void setString(){
        //设置 redis 字符串数据
        jedis.set("key2", "test2");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("key2"));
    }

    /**
     * 设置list
     */
    @Test
    public void setList(){
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        System.out.println("插入成功");
    }

    /**
     * 删除redis
     * @param key
     * @param count
     * @param value
     */
    public void remValue(String key,int count,String value){
        jedis.lrem(key, count, value);
    }

    /**
     * 查看redis
     */
    @Test
    public void getList(){
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
        System.out.println("------------------------");
        List<String> list1 = jedis.lrange("site-list", 0 ,-1);
        for(int i=0; i<list1.size(); i++) {
            System.out.println("列表项为: "+list1.get(i));
        }
    }
}
