package xyz.huanxicloud.blockchainj.core.common.encrypt;


import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author: huanxi
 * @date: 2019/1/1 20:28
 */
public class Sha256 {
    public static String sum(String input) {
        return DigestUtil.sha256Hex(input);
    }
}
