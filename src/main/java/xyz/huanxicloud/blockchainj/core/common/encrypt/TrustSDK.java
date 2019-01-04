/**
 * Project Name:trustsql_sdk
 * File Name:TrustSDK.java
 * Package Name:com.tencent.trustsql.sdk
 * Date:Jul 26, 201710:30:31 AM
 * Copyright (c) 2017, Tencent All Rights Reserved.
 */

package xyz.huanxicloud.blockchainj.core.common.encrypt;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;
import xyz.huanxicloud.blockchainj.core.common.encrypt.algorithm.ECDSAAlgorithm;
import xyz.huanxicloud.blockchainj.core.common.encrypt.exception.ErrorNum;
import xyz.huanxicloud.blockchainj.core.common.encrypt.exception.TrustSDKException;

import java.io.UnsupportedEncodingException;

/**
 * ClassName:TrustSDK <br/>
 * Date: Jul 26, 2017 10:30:31 AM <br/>
 *
 * @author Rony
 * @since JDK 1.7
 */
public class TrustSDK {

    /**
     * generatePairKey:产生一对公私钥, 并返回. <br/>
     *
     * @author Rony
     * @return 返回公私钥对
     * @throws TrustSDKException
     * TrustSDKException
     * @since JDK 1.7
     */
/*	public static PairKey generatePairKey() throws TrustSDKException {
		return generatePairKey(false);
	}*/

    /**
     * generatePairKey:生成私钥公钥对. <br/>
     *
     * @author ronyyang
     * @param encodePubKey  是否压缩
     * @return PairKey
     * @throws TrustSDKException
     * TrustSDKException
     * @since JDK 1.7
     */
/*	public static PairKey generatePairKey(boolean encodePubKey) throws TrustSDKException {
		try {
			PairKey pair = new PairKey();
			String privateKey = ECDSAAlgorithm.generatePrivateKey();
			String pubKey = ECDSAAlgorithm.generatePublicKey(privateKey.trim(), encodePubKey);
			pair.setPrivateKey(privateKey);
			pair.setPublicKey(pubKey);
			return pair;
		} catch (Exception e) {
			throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
		}
	}*/

    /**
     * checkPairKey:验证一对公私钥是否匹配. <br/>
     *
     * @author ronyyang
     * @param prvKey 输入 存放私钥 长度必须为PRVKEY_DIGEST_LENGTH
     * @param pubKey 输入 存放公钥 长度必须为PUBKEY_DIGEST_LENGTH
     * @return true 公私钥匹配  false 公私钥不匹配
     * @throws TrustSDKException TrustSDKException
     * @since JDK 1.7
     */
    public static boolean checkPairKey(String prvKey, String pubKey) throws TrustSDKException {
        if (StringUtils.isEmpty(prvKey) || StringUtils.isEmpty(pubKey)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            String correctPubKey = ECDSAAlgorithm.generatePublicKey(prvKey.trim(), true);
            return pubKey.trim().equals(correctPubKey);
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
        }
    }

    /**
     * generatePubkeyByPrvkey: 通过私钥计算相应公钥. <br/>
     *
     * @author Rony
     * @param privateKey
     *            私钥字符串
     * @param encode
     *            是否压缩公钥
     * @return 返回公钥字符串
     * @throws TrustSDKException
     * TrustSDKException
     * @since JDK 1.7
     */
    public static String generatePubkeyByPrvkey(String privateKey, boolean encode) throws TrustSDKException {
        if (StringUtils.isEmpty(privateKey)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            return ECDSAAlgorithm.generatePublicKey(privateKey, encode);
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
        }
    }

    /**
     * generatePubkeyByPrvkey: 通过私钥计算相应公钥. <br/>
     *
     * @author Rony
     * @param privateKey
     *            私钥字符串
     * @return 返回公钥字符串
     * @throws TrustSDKException TrustSDKException
     * @since JDK 1.7
     */
    public static String generatePubkeyByPrvkey(String privateKey) throws TrustSDKException {
        return generatePubkeyByPrvkey(privateKey, false);
    }

    public static String decodePubkey(String encodePubKey) throws TrustSDKException {
        if (StringUtils.isEmpty(encodePubKey)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            return ECDSAAlgorithm.decodePublicKey(encodePubKey);
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
        }
    }

    /**
     * generateAddrByPubkey:通过公钥获取对应地址. <br/>
     *
     * @author Rony
     * @param pubKey
     *            公钥字符串
     * @return address
     * @throws TrustSDKException
     * TrustSDKException
     * @since JDK 1.7
     */
    public static String generateAddrByPubkey(String pubKey) throws TrustSDKException {
        if (StringUtils.isEmpty(pubKey)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            return ECDSAAlgorithm.getAddress(Base64.decodeBase64(pubKey));
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
        }
    }

    /**
     * generateAddrByPrvkey:通过私钥计算相应地址. <br/>
     *
     * @author Rony
     * @param privateKey
     *            私钥字符串
     * @return Address
     * @throws TrustSDKException TrustSDKException
     * @since JDK 1.7
     */
    public static String generateAddrByPrvkey(String privateKey) throws TrustSDKException {
        if (StringUtils.isEmpty(privateKey)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            String pubKey = ECDSAAlgorithm.generatePublicKey(privateKey);
            return generateAddrByPubkey(pubKey);
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
        }
    }

    /**
     * signString:为字符串进行签名, 并返回签名. <br/>
     *
     * @author Rony
     * @param privateKey
     *            私钥字符串
     * @param data
     *            需要签名的字符数组
     * @return 返回签名字符串
     * @throws TrustSDKException TrustSDKException
     * @since JDK 1.7
     */
    public static String signString(String privateKey, byte[] data) throws TrustSDKException {
        if (StringUtils.isEmpty(privateKey)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            return ECDSAAlgorithm.sign(privateKey, data);
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.SIGN_ERROR.getRetCode(), ErrorNum.SIGN_ERROR.getRetMsg(), e);
        }
    }

    public static String signString(String privateKey, String data) throws TrustSDKException, UnsupportedEncodingException {
        return signString(privateKey, data.getBytes("UTF-8"));
    }

    /**
     * verifyString:验证一个签名是否有效. <br/>
     *
     * @author Rony
     * @param pubKey
     *            公钥字符串
     * @param srcString
     *            源字符串
     * @param sign
     *            签名字符串
     * @return 返回验证是否通过 true:验证成功 false:验证失败
     * @throws TrustSDKException TrustSDKException
     * @since JDK 1.7
     */
    public static boolean verifyString(String pubKey, String srcString, String sign) throws TrustSDKException {
        if (StringUtils.isEmpty(pubKey) || StringUtils.isEmpty(srcString) || StringUtils.isEmpty(sign)) {
            throw new TrustSDKException(ErrorNum.INVALID_PARAM_ERROR.getRetCode(), ErrorNum.INVALID_PARAM_ERROR.getRetMsg());
        }
        try {
            return ECDSAAlgorithm.verify(srcString, sign, pubKey);
        } catch (Exception e) {
            throw new TrustSDKException(ErrorNum.ECDSA_ENCRYPT_ERROR.getRetCode(), ErrorNum.ECDSA_ENCRYPT_ERROR.getRetMsg(), e);
        }
    }


}
