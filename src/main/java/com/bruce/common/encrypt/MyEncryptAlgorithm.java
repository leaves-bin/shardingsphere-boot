package com.bruce.common.encrypt;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Author: yongbin
 * @Date: 2021/5/7
 * @Desc: <pre></pre>
 */
@Getter
@Setter
public final class MyEncryptAlgorithm implements EncryptAlgorithm {

    private static final String HAES_KEY = "haes-key-value";

    private Properties props = new Properties();

    private byte[] secretKey;

    @Override
    public void init() {
        secretKey = createSecretKey();
    }

    private byte[] createSecretKey() {
      return HAES_KEY.getBytes();
    }

    @Override
    public String encrypt(final Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        return Base64.encodeBase64String(StringUtils.getBytesUtf8(String.valueOf(plaintext)));
    }

    @Override
    public Object decrypt(final String ciphertext) {
        if (null == ciphertext) {
            return null;
        }
        return new String(Base64.decodeBase64(ciphertext), StandardCharsets.UTF_8);
    }

    @Override
    public String getType() {
        return "HAES";
    }

}
