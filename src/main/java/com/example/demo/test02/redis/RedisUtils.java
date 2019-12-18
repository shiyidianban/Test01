package com.example.demo.test02.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author FLY
 * @CreateDate 2019-12-18 11:54
 * @ProjectName Test01
 * @Desc
 */
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    //读取缓存
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key) + "";
    }

    //写入缓存
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //写入定义过期缓存
    public boolean setTimeout(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value, 20, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //更新缓存
    public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //删除
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //从右边添加
    public Long rightpush(String name, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.rightPush(name, value);
    }

    //查询(从第0个开始查询到最后一个 -1表示最后一个)
    public List<String> getpush(String name) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.range(name, 0, -1);
    }

    //修改index表示第几个
    public void updatepush(String name, long index, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.set(name, index, value);
    }

    //删除

    /**
     * count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT。
     * count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
     * count = 0 : 移除表中所有与 VALUE 相等的值
     */
    public long deletepush(String name, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.remove(name, 0, value);
    }

    //批量添加
    public Long rightpushall(String name, List<String> userList) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.rightPushAll(name, userList);
    }

    //trim截取集合元素长度，保留长度内的数据。
    public void dotrim(String name, long start, long end) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.trim(name, 0, 2);
    }

    //插入对象
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    //获取对象
    public String setString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    //集合set
    public void addSet(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    //集合set查询
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    //有序集合
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    //有序集合获取
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }
}
