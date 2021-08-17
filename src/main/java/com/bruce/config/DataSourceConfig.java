package com.bruce.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: yongbin
 * @Date: 2021/5/6
 * @Desc: <pre></pre>
 */
@Configuration
@AutoConfigureAfter({SpringBootConfiguration.class})
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource(@Qualifier("shardingSphereDataSource") DataSource dataSource) {
        return dataSource;
    }

}
