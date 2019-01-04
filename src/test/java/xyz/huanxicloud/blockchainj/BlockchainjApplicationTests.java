package xyz.huanxicloud.blockchainj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.huanxicloud.blockchainj.core.blockchain.BlockChain;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockchainjApplicationTests {

    @Resource
    BlockChain blockChain;

    @Test
    public void contextLoads() {
        blockChain.init();
    }

}

