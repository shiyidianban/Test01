package com.example.demo.test02.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;


/**
 * @author FLY
 * @date 2019-12-18 11:21
 */
@Slf4j
public class RedisUtil {
    private String host = "127.0.0.1";
    private Integer port = 6379;
    private JedisPool pool = null;
    private Jedis redis = null;

    //构造函数,创建对象时进行初始化
    public RedisUtil() {
        if (pool == null) {

            // 池基本配置
            JedisPoolConfig config = new JedisPoolConfig();
            // 最大连接数, 默认8个
            config.setMaxTotal(20);
            // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(5);
            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWaitMillis(10000);
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(false);

            //创建redis连接池
            this.pool = new JedisPool(config, host, port);
            //this.pool = new JedisPool(new JedisPoolConfig(), GlobalSettings.getProperty("redis.master.host"), Integer.parseInt(GlobalSettings.getProperty("redis.master.port")));
            //获取Jedis实例
            this.redis = pool.getResource();
            log.info("连接redis成功");
        }
    }

    /**
     * 关闭连接
     *
     * @param redis
     */
    public void quitConnection(Jedis redis) {
        if (redis != null) {
            redis.quit();
            log.info("关闭redis成功");
            //pool.returnResource(redis);
        }
    }

    /**
     * 获取key对应的value
     * <p>
     * 说明：方法中目前只针对key数据类型为String和hash的情况作了处理，其他数据类型可根据需要进行扩展即可
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        String value = null;
        try {
            if (redis == null || !redis.exists(key)) {
                log.info("key:" + key + " is not found");
                quitConnection(redis);
                return value;
            }
            //获取key对应的数据类型
            String type = redis.type(key);
            log.info("key:" + key + " 的类型为：" + type);
            switch (RedisEnum.getByValue(type)){
                case STRING:
                    //get(key)方法返回key所关联的字符串值
                    value = redis.get(key);
                    break;
                case HASH:
                    //以下方法仅适用于list.size=1时，否者value将取集合中最后一个元素的值
                    List<String> list = redis.hvals(key);//hvals(key)返回哈希表 key 中所有域的值
                    //Set<String> set = redis.hkeys(key);
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        value = it.next();
                        log.info("value:" + value);
                    }
                    break;
                case LIST:
                    log.info(key + "类型为list暂未处理...");
                    break;
                case SET:
                    log.info(key + "类型为set暂未处理...");
                    break;
                default:
                    log.info(key + "类型为未知类型...");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭连接
            quitConnection(redis);
        }

        return value;
    }
}
