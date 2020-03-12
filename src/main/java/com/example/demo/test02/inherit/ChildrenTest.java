package com.example.demo.test02.inherit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author FLY
 * @date 2020-03-02 11:24
 */
public class ChildrenTest extends FatherTest {


    public void test01(HashMap list){

    }

    public static void main(String[] args) {
        ChildrenTest c = new ChildrenTest();
        c.test01(new ArrayList<>());
    }
}
