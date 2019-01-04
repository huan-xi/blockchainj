package xyz.huanxicloud.blockchainj.core.blockchain;

import org.springframework.stereotype.Service;
import xyz.huanxicloud.blockchainj.core.Constants;
import xyz.huanxicloud.blockchainj.core.blockchain.block.*;
import xyz.huanxicloud.blockchainj.core.blockchain.block.instuction.Instruction;
import xyz.huanxicloud.blockchainj.core.common.util.CommonUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: huanxi
 * @date: 2019/1/4 17:16
 * 区块服务
 */
@Service
public class BlockService {
    /**
     *
     * 生成新区块（生成者）
     * @param publicKey 创建区块人公钥
     */
    public Block createBlock(String publicKey, BlockBody blockBody) {
        //创建区块头
        BlockHeader blockHeader = new BlockHeader();
        blockHeader.setVersion(Constants.Version);
        blockHeader.setTimeStamp(CommonUtils.getTimestamp());
        //计算hash merkle
        List<Instruction> instructions = blockBody.getInstructions();
        List<String> hashList = instructions.stream().map(Instruction::getHash).collect(Collectors
                .toList()); //TODO merkle tree
        blockHeader.setHashMerkleRoot(new MerkleTree(hashList).build().getRoot());
        blockHeader.setNonce(0); //测试
        blockHeader.setPublicKey(publicKey);

        return new Block(blockHeader, blockBody);
    }


}
