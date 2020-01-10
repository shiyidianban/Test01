package com.example.demo.test02.ioStream;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

/**
 * @author FLY
 * @date 2019-12-16 13:48
 */
@Slf4j
public class IOTest01 {

    @SneakyThrows
    public static void main(String[] args) {
        IOTest01 a1 = new IOTest01();

        //电脑d盘中的abc.txt 文档
        String filePath = "files/abc.txt";
        String result = a1.readFile(filePath);
        log.info(result);
    }


    /**
     * 读取指定文件的内容
     *
     * @param filePath ： 文件的路径
     * @return 返回的结果
     */
    public String readFile(String filePath) {
        InputStream fis = null;
        String result = "";
        try {
            //SpringBoot读取resource下的文件内容
//            ClassPathResource classPathResource = new ClassPathResource(filePath);
//            InputStream inputStream =classPathResource.getInputStream();
            //2。
            fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
            //3。
            // fis = this.getClass().getResourceAsStream(filePath);

            //2. 返回这个输入流中可以被读的剩下的bytes字节的估计值；
            int size = fis.available();
            //3. 根据输入流中的字节数创建byte数组；
            byte[] array = new byte[size];
            //4.把数据读取到数组中；
            fis.read(array);

            //5.根据获取到的Byte数组新建一个字符串，然后输出；
            result = new String(array);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
