package com.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author: yongbin
 * @Date: 2020/3/6
 * @Desc: <pre></pre>
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties
public class SharedingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharedingApplication.class, args);
    }

}
