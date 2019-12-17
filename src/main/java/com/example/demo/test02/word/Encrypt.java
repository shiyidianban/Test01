package com.example.demo.test02.word;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.ProtectionType;

/**
 * @Author FLY
 * @CreateDate 2019-12-17 17:00
 * @ProjectName Test01
 * @Desc
 */
public class Encrypt {

    public static void main(String[] args){
        //加载测试文档
        String input = "C:\\权限需求\\20190418-2-权限管理需求.docx";
        String output= "C:\\权限需求\\20190417-2-权限管理需求11.docx.pdf";
        Document doc = new Document(input);
//保存结果文件
        doc.saveToFile(output, FileFormat.PDF);
//        doc.encrypt("123");//设置文档打开密码
        doc.protect(ProtectionType.Allow_Only_Reading,"123");//设置文档只读密码
        //doc.protect(ProtectionType.Allow_Only_Comments,"123");//设置文档只允许添加批注
        //doc.protect(ProtectionType.Allow_Only_Form_Fields,"123");//只允许表单域
        //doc.protect(ProtectionType.Allow_Only_Revisions,"123");//只允许修订


        //保存加密后的文档
//        doc.saveToFile(output);
//        doc.dispose();
    }

}
