package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试SimpleDateFormat
 *
 * @author FLY
 * @date 2020-05-28 10:23
 */
@Slf4j
public class SimpleDateFormatTest {

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date string2DateTime(String dateStr) {
        Date date = null;
        try {
            if (dateStr != null && !dateStr.trim().equals("")) {
                date = dateTimeFormat.parse(dateStr);
            }
        } catch (Exception e) {
            log.warn("字符串转日期值失败！" + e.getMessage());
        }
        return date;
    }

    public static void main(String[] args) {
        final DateFormat df = new SimpleDateFormat("yyyyMMdd,HHmmss");
        ExecutorService ts = Executors.newFixedThreadPool(100);
        for (; ; ) {
            ts.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //生成随机数，格式化日期
                        String format = df.format(new Date(Math.abs(new Random().nextLong())));
                        System.out.println(format);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            });
        }
    }
}
