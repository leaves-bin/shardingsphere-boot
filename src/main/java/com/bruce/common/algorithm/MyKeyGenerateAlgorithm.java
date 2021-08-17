package com.bruce.common.algorithm;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.util.Properties;
import java.util.UUID;

/**
 * @Author: yongbin
 * @Date: 2021/5/7
 * @Desc: <pre></pre>
 */
@Getter
@Setter
public final class MyKeyGenerateAlgorithm implements KeyGenerateAlgorithm {

    private Properties props = new Properties();

    @Override
    public void init() {
    }

    @Override
    public synchronized Comparable<?> generateKey() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getType() {
        return "MYUUID";
    }
}
