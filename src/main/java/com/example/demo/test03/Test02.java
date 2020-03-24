package com.example.demo.test03;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

/**
 * @author FLY
 * @date 2020-03-24 20:36
 */
public class Test02 {

    private StringStack str1;

    private StringStack str2;

    public Test02(){
        str1 = new StringStack();
        str2 = new StringStack();
    }

    public void init(){
        str1.clear();
        str2.clear();
    }

    public void push(String n){
         str1.push(n);
    }

    public String pop(){
        while (!str1.isEmpty()){
            str2.push(str1.pop());
        }

        String str = str2.popString();

        while (!str2.isEmpty()){
            str1.push(str2.pop());
        }

        return str;
    }

    public Boolean isEmpty(){
        return str1.isEmpty();
    }
}
