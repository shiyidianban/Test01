package com.example.demo.test02.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author FLY
 * @Createdate 2019-12-14 14:23
 * @ProjectName Test01
 * @Desc com.example.demo.test02.model
 */
@Data
@ToString
public class ReflectionModel {

    private boolean bo1; //1 * 1

    private byte by1;   //1 * 8

    private char c1;    //2 * 8

    private short s1;   //2 * 8

    private int i1;     //4 * 8

    private float f1;   //4 * 8

    private double d1;  //8 * 8

    private long l1;  //8 * 8

    private Boolean b2;

    private Byte by2;

    private Character c2;

    private Short s2;

    private Integer i2;

    private Float f2;

    private Double d2;

    private Long l2;

    private String testTestTestTestTest() {
        return null;
    }
}
