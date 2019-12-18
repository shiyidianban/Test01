# MyBatis反向生成工具包

### maven配置模版
导包：这个可有可无，因为已经在插件配置好了
```xml
<!-- SpringBoot - MyBatis 逆向工程 -->
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.7</version>
</dependency>
``` 
配置逆向生成插件，这个添加了一个tk.mybatis的依赖，相关使用可以去[tk.mybatis](https://github.com/abel533/Mapper)，其中包含分页插件有兴趣可以看一下。
```xml
<build>
    <plugins>
        <!-- MyBatis 逆向工程 插件 -->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.7</version>
            <configuration>
                <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
                <overwrite>true</overwrite>
                <verbose>true</verbose>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.18</version>
                </dependency>
                <dependency>
                    <groupId>tk.mybatis</groupId>
                    <artifactId>mapper</artifactId>
                    <version>4.1.5</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```

然后可以查看generatorConfig.xml配置
1. 把generatorConfig.xml放到resources文件夹下，并修改数据库地址和要反向生成表
2. 然后点击maven即可生成，如图所示：
![mybatis01.jpg](../../../../../../resources/img/mybatis01.jpg)