package xyz.huanxicloud.blockchainj.core.common.start;

import org.springframework.stereotype.Component;
import xyz.huanxicloud.blockchainj.core.blockchain.BlockChain;
import xyz.huanxicloud.blockchainj.core.network.client.SocketClientManager;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author: huanxi
 * @date: 2019/1/4 18:09
 */
@Component
public class AppStart {
    @Resource
    BlockChain blockChain;
    @Resource
    SocketClientManager socketClientManager;
    @PostConstruct
    public void initApp() {
        //获取所有节点
        //连接各节点
        socketClientManager.start();
        initDB();
    }

    public void initDB() {
        //创建本地数据库

        //初始化表
    }


}
