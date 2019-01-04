/**
 * Project Name:trustsql_sdk
 * File Name:DESAlgoUtil2.java
 * Package Name:com.tencent.trustsql.sdk.algo
 * Date:Jul 28, 201710:38:59 AM
 * Copyright (c) 2017, NUCC All Rights Reserved.
 *
*/

package xyz.huanxicloud.blockchainj.core.common.encrypt.algorithm;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

/**
 * ClassName:DESAlgoUtil2 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     Jul 28, 2017 10:38:59 AM <br/>
 * @author   Rony
 * @since    JDK 1.7
 */
public class DESAlgorithm {
    /**
     * 密钥算法
     * */
    public static final String KEY_ALGORITHM = "DESede";

    /**
     * 加密/解密算法/工作模式/填充方式
     * */
    public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 转换密钥
     *
     * @param key
     *            二进制密钥
     * @return Key 密钥
     * */
    public static Key toKey(byte[] key) throws Exception {
        // 实例化Des密钥
        DESedeKeySpec dks = new DESedeKeySpec(key);
        // 实例化密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        // 生成密钥
        return keyFactory.generateSecret(dks);
    }

    /**
     * 加密数据
     *
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return byte[] 加密后的数据
     * */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 还原密钥
        Key k = toKey(key);
        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * 解密数据
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return byte[] 解密后的数据
     * */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 欢迎密钥
        Key k = toKey(key);
        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }
}

