package com.example.demo.test02.clazz;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author FLY
 * @Createdate 2019-12-14 10:39
 * @ProjectName Test01
 * @Desc com.example.demo.test02.clazz
 */
@Slf4j
public class ClassLoaderTest02 {

    //获取主类的类加载器
    @SneakyThrows
    public static void main(String[] args) {

        log.info("加载器名字：{}",ClassLoaderTest02.class.getName());
        ClassLoader loader = ClassLoaderTest02.class.getClassLoader();
        log.info("加载器名字：{}",ClassLoader.getSystemClassLoader().getClass().getName());
        while (loader != null){
            log.info("加载器名字：{}",loader.getClass().getName());
            loader = loader.getParent();
        }

        java.net.URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            log.info("urls：{}",urls[i]);
        }
    }
}
