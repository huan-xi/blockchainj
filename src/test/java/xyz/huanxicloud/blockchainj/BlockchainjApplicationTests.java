package xyz.huanxicloud.blockchainj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.huanxicloud.blockchainj.core.blockchain.BlockChain;
import xyz.huanxicloud.blockchainj.core.blockchain.BlockService;
import xyz.huanxicloud.blockchainj.core.blockchain.block.instuction.InstructionService;
import xyz.huanxicloud.blockchainj.data.dao.RoleMapper;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockchainjApplicationTests {

    @Resource
    BlockChain blockChain;
    @Resource
    BlockService blockService;
    @Resource
    InstructionService instructionService;

    @Autowired
    RoleMapper roleMapper;
    @Test
    public void contextLoads() {
        /*Block block = blockService.createBlock(CollectionUtil.newArrayList(instructionService.build("第二次交易"), instructionService.build("第三次交易")));
        blockChain.addBlock(block);*/
        roleMapper.test();
    }

}

