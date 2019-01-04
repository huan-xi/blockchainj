package xyz.huanxicloud.blockchainj.core.blockchain.block;

import xyz.huanxicloud.blockchainj.core.common.encrypt.Sha256;

/**
 * @author: huanxi
 * @date: 2019/1/1 17:57
 * 区块结构
 */
public class Block {
    /**
     * 区块头
     */
    private BlockHeader blockHeader;
    /**
     * 区块body
     */
    private BlockBody blockBody;
    /**
     * 该区块的hash
     */
    private String hash;

    public Block(BlockHeader blockHeader, BlockBody blockBody) {
        this.blockHeader = blockHeader;
        this.blockBody = blockBody;
        this.setHash();
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockHeader=" + blockHeader +
                ", blockBody=" + blockBody +
                ", hash='" + hash + '\'' +
                '}';
    }

    public BlockHeader getBlockHeader() {
        return blockHeader;
    }

    public void setBlockHeader(BlockHeader blockHeader) {
        this.blockHeader = blockHeader;
    }

    public BlockBody getBlockBody() {
        return blockBody;
    }

    public void setBlockBody(BlockBody blockBody) {
        this.blockBody = blockBody;
    }

    public String getHash() {
        return hash;
    }

    public void setHash() {
        this.hash = Sha256.sum(blockHeader.toString() + blockBody.toString());
    }
}
