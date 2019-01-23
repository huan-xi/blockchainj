package xyz.huanxicloud.blockchainj.core.event;

import org.springframework.context.ApplicationEvent;
import xyz.huanxicloud.blockchainj.core.blockchain.block.Block;

/**
 * 确定生成block的Event（添加到rocksDB，执行sqlite语句，发布给其他节点）
 */
public class AddBlockEvent extends ApplicationEvent {
    public AddBlockEvent(Block block) {
        super(block);
    }
}
