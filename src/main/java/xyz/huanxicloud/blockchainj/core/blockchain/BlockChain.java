package xyz.huanxicloud.blockchainj.core.blockchain;

import cn.hutool.core.collection.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.huanxicloud.blockchainj.core.blockchain.block.Block;
import xyz.huanxicloud.blockchainj.core.blockchain.block.instuction.InstructionService;
import xyz.huanxicloud.blockchainj.core.blockchain.db.DbStore;
import xyz.huanxicloud.blockchainj.core.common.util.FastJsonUtil;

import javax.annotation.PostConstruct;
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
    private BlockService blockService;
    @Resource
    InstructionService instructionService;
    private final String lastBlockHashKey = "LastHash";
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String lastBlockHash;

    /**
     * 创建创世块
     */
    private Block createGenesisBlock() {
        //构建区块体
        return blockService.createBlock(CollectionUtil.newArrayList(instructionService.build("创世块")));
    }

    /**
     * 本地初始化区块链
     */
    @PostConstruct
    public void init() {
        //获取last hash 如果没有则创建创世块
        lastBlockHash = dbStore.get(lastBlockHashKey);
        if (StringUtils.isEmpty(lastBlockHash)) addBlock(createGenesisBlock());
    }

    //添加新区块
    public void addBlock(Block block) {
        lastBlockHash = block.getHash();
        dbStore.put(lastBlockHashKey, lastBlockHash);
        dbStore.put(lastBlockHash, FastJsonUtil.toJSONString(block));
    }

    //获取最后一个区块
    public Block getLastBlock() {
        return getBlockByHash(lastBlockHash);
    }

    public Block getBlockByHash(String hash) {
        String blockJson = dbStore.get(hash);
        return FastJsonUtil.toBean(blockJson, Block.class);
    }

    public String getLastBlockHash() {
        return lastBlockHash;
    }

    public void setLastBlockHash(String lastBlockHash) {
        this.lastBlockHash = lastBlockHash;
    }
}
