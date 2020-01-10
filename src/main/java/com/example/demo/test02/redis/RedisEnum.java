package com.example.demo.test02.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author FLY
 * @date 2019-12-18 10:54
 */
@Getter
@AllArgsConstructor
public enum RedisEnum {

    LIST("list", "列表"),
    STRING("string", "字符串"),
    HASH("hash", "字典"),
    SET("set", "集合"),
    SORT("sortedset", "有序集合"),
    ;

    /**
     * code
     */
    private String value;

    /**
     * 描述
     */
    private String desc;

    // 根据value返回枚举类型,主要在switch中使用
    public static RedisEnum getByValue(String value) {
        for (RedisEnum code : values()) {
            if (code.getValue().equals(value)) {
                return code;
            }
        }
        return null;
    }
}
