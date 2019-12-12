package com.example.demo.test01.readObject;

import java.io.Serializable;

/**
 * @author wu161 2018年12月18日下午9:48:25
 */
public class DataInfo implements Serializable {

    private String name;

    private String value;

    private Integer type;

    public DataInfo() {
        super();
    }

    public DataInfo(String name, String value, Integer type) {
        super();
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
