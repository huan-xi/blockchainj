package xyz.huanxicloud.blockchainj.core.blockchain.block.instuction;

import xyz.huanxicloud.blockchainj.core.common.encrypt.Sha256;

/**
 * @author: huanxi
 * @date: 2019/1/1
 * 区块body内一条指令
 */
public class Instruction extends InstructionBase {
    /**
     * 指令的内容
     */
    private String json;
    /**
     * 时间戳
     */
    private Long timeStamp;
    /**
     * 操作人的公钥
     */
    private String publicKey;
    /**
     * 签名
     */
    private String sign;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHash() {
        return Sha256.sum(toString());
    }


    @Override
    public String toString() {
        return "Instruction{" +
                "json='" + json + '\'' +
                ", timeStamp=" + timeStamp +
                ", publicKey='" + publicKey + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
