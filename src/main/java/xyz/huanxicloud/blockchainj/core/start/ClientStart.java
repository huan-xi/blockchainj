package xyz.huanxicloud.blockchainj.core.start;

import org.springframework.stereotype.Component;
import xyz.huanxicloud.blockchainj.core.blockchain.BlockChain;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author: huanxi
 * @date: 2019/1/4 18:09
 */
@Component
public class ClientStart {
    @Resource
    BlockChain blockChain;

    @PostConstruct
    public void initApp() {
        initDB();
    }

    public void initDB() {
        //创建本地数据库

        //初始化表
    }


}
