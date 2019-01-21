package xyz.huanxicloud.blockchainj.core;

import java.math.BigInteger;

/**
 * @author: huanxi
 * @date: 2019/1/4 17:22
 */
public class Constants {
    public final static int Version = 1;
    public static final String RANDOM_NUMBER_ALGORITHM_PROVIDER = "SUN";
    public static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";
    public static final BigInteger MAXPRIVATEKEY = new BigInteger("00FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364140", 16);
    public static String blockChainPath = "./data/blockchain";
}
