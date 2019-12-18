package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String str1 = "hrm.test.dev.thundersdata.com/";
        Pattern p1 = Pattern.compile("/*?(.test)?(.dev)?.thundersdata.com/");
        Matcher m1 = p1.matcher(str1);
        while (m1.find()) {
            System.out.println(m1.group());
        }
    }

}
