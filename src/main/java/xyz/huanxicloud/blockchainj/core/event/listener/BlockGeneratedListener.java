package xyz.huanxicloud.blockchainj.core.event.listener;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.huanxicloud.blockchainj.core.blockchain.block.Block;
import xyz.huanxicloud.blockchainj.core.event.AddBlockEvent;
import xyz.huanxicloud.blockchainj.core.network.server.SocketServer;

import javax.annotation.Resource;

/**
 * @author: huanxi
 * @date: 2019/1/22 23:04
 * 生成区块时间监听（观察者模式）
 * 广播区块
 */
@Component
public class BlockGeneratedListener {
    /**
     * 接收到添加区块事件
     *
     * @param addBlockEvent
     */
    @Resource
    SocketServer server;
    private static Log log = LogFactory.get(SocketServer.class);

    @EventListener(AddBlockEvent.class)

    public void blockGenerated(AddBlockEvent addBlockEvent) {
        log.info("创建区块开始广播");
        Block block = (Block) addBlockEvent.getSource();
        server.broadcastBlock(block);
    }
}
