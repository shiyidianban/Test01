package com.example.demo.test02.ioStream;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @author FLY
 * @date 2019-12-16 13:48
 */
@Slf4j
public class IOTest02 {

    @SneakyThrows
    public static void main(String[] args) {
        IOTest02 a1 = new IOTest02();

        //resources下的files的abc.txt文档
        String filePath = "files/abc.txt";
        readFileByLines(filePath);
    }


    @SneakyThrows
    public static void readFileByLines(String fileName) {
        fileName = String.format("classpath:%s",fileName);
        File file = ResourceUtils.getFile(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读一行，读入null时文件结束
            while ((tempString = reader.readLine()) != null) {
                Thread.sleep(500);
                System.out.println(tempString);
                line++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}
