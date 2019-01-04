/**
 * Project Name:trustsql_sdk
 * File Name:ErrorNum.java
 * Package Name:com.tencent.trustsql.sdk
 * Date:Jul 26, 20172:59:02 PM
 * Copyright (c) 2017, Tencent All Rights Reserved.
 *
*/

package xyz.huanxicloud.blockchainj.core.common.encrypt.exception;
/**
 * ClassName:ErrorNum <br/>
 * Date:     Jul 26, 2017 2:59:02 PM <br/>
 * @author   Rony
 * @version
 * @since    JDK 1.7
 * @see
 */
public enum ErrorNum {

	INVALID_PARAM_ERROR("001", "参数错误"),
	DES3_ENCRYPT_ERROR("002", "DES3加解密错误"),
	AES_ENCRYPT_ERROR("003", "AES加解密错误"),
	ECDSA_ENCRYPT_ERROR("004", "ECDSA加解密错误"),
	SIGN_ERROR("005", "签名错误"),
	GENERATE_SIGN_ERROR("006", "生成签名错误"),
	GENERATE_SQL_ERROR("007", "生成SQL错误"),
	VERIFY_SIGN_ERROR("008", "验证签名错误");

	private String retCode;
	private String retMsg;

	ErrorNum(String retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
}

