package xyz.huanxicloud.blockchainj.core.blockchain;

import cn.hutool.core.collection.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.huanxicloud.blockchainj.core.blockchain.block.Block;
import xyz.huanxicloud.blockchainj.core.blockchain.block.BlockBody;
import xyz.huanxicloud.blockchainj.core.blockchain.block.instuction.InstructionService;
import xyz.huanxicloud.blockchainj.core.blockchain.db.DbStore;
import xyz.huanxicloud.blockchainj.core.common.AppProperty;

import javax.annotation.Resource;

/**
 * @author: huanxi
 * @date: 2019/1/4 17:48
 * 区块链 服务
 */
@Service
public class BlockChain {
    @Resource
    private DbStore dbStore;
    @Resource
    AppProperty appProperty;
    @Resource
    InstructionService instructionService;
    private final String LastBlockHashKey = "lasthash";
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String LastBlockHash;

    /**
     * 创建创世块
     */
    private Block createGenesisBlock() {
        BlockService blockService = new BlockService();

        //构建区块体
        BlockBody blockBody = new BlockBody();
        blockBody.setInstructions(CollectionUtil.newArrayList(instructionService.build("创世块")));
        return blockService.createBlock(appProperty.getPublicKey(), blockBody);
    }

    /**
     * 本地初始化区块链
     */
    public void init() {
        //获取last hash 如果没有则创建创世块
        LastBlockHash = dbStore.get(LastBlockHashKey);
        if (StringUtils.isEmpty(LastBlockHash)) {
            this.LastBlockHash = createGenesisBlock().getHash();
            dbStore.put(LastBlockHashKey, this.LastBlockHash);
        } else this.LastBlockHash = dbStore.get(LastBlockHashKey);
    }

    //获取最后一个区块
    public String getLastBlock() {
        return dbStore.get(LastBlockHash);
    }
}
