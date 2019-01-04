package xyz.huanxicloud.blockchainj.core.blockchain.block;

/**
 * @author: huanxi
 * @date: 2019/1/1 17:57
 * 区块头结构
 */
public class BlockHeader {
    /**
     * 版本号
     */
    private int version;
    /**
     * 上一区块的hash
     */
    private String hashPreviousBlock;
    /**
     * merkle tree根节点hash
     */
    private String hashMerkleRoot;
    /**
     * 生成该区块的公钥
     */
    private String publicKey;
    /**
     * 时间戳
     */
    private long timeStamp;
    /**
     * 32位随机数
     */
    private long nonce;

    /**
     * 该区块里每条交易信息的hash集合，按顺序来的，通过该hash集合能算出根节点hash
     */
    @Override
    public String toString() {
        return "BlockHeader{" +
                "version=" + version +
                ", hashPreviousBlock='" + hashPreviousBlock + '\'' +
                ", hashMerkleRoot='" + hashMerkleRoot + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", timeStamp=" + timeStamp +
                ", nonce=" + nonce +
                '}';
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getHashPreviousBlock() {
        return hashPreviousBlock;
    }

    public void setHashPreviousBlock(String hashPreviousBlock) {
        this.hashPreviousBlock = hashPreviousBlock;
    }

    public String getHashMerkleRoot() {
        return hashMerkleRoot;
    }

    public void setHashMerkleRoot(String hashMerkleRoot) {
        this.hashMerkleRoot = hashMerkleRoot;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }


    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }
}
