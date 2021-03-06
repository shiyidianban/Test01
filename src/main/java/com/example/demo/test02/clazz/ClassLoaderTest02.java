package com.example.demo.test02.clazz;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author FLY
 * @date 2019-12-14 10:39
 */
@Slf4j
public class ClassLoaderTest02 {

    //获取主类的类加载器
    @SneakyThrows
    public static void main(String[] args) {
        log.info("加载器名字1：{}",Thread.currentThread().getContextClassLoader().getClass().getName());
        log.info("加载器名字2：{}",ClassLoaderTest02.class.getName());
        ClassLoader loader = ClassLoaderTest02.class.getClassLoader();
        log.info("加载器名字3：{}",ClassLoader.getSystemClassLoader().getClass().getName());
        while (loader != null){
            log.info("加载器名字4：{}",loader.getClass().getName());
            loader = loader.getParent();
        }

        java.net.URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            log.info("urls：{}",urls[i]);
        }
        System.out.println(System.getProperty("sun.boot.class.path"));

    }
}
