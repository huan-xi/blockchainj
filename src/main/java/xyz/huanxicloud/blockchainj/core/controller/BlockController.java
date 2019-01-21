package xyz.huanxicloud.blockchainj.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanxicloud.blockchainj.core.blockchain.BlockChain;
import xyz.huanxicloud.blockchainj.core.common.returnmsg.ReturnMessage;

import javax.annotation.Resource;

/**
 * @author: huanxi
 * @date: 2019/1/4 19:31
 */
@Api(tags = "区块接口")
@RestController
@RequestMapping("/block")
public class BlockController {
    @Resource
    private BlockChain blockChain;


    @GetMapping("last")
    @ApiOperation(value = "查看最后一个区块")
    public ReturnMessage getLast() {
        return new ReturnMessage(1, blockChain.getLastBlock());
    }

    @PostMapping("create")
    @ApiOperation(value = "创建一个交易")
    public ReturnMessage createBlock() {
        return new ReturnMessage(1, blockChain.getLastBlock());
    }

    @GetMapping("all")
    @ApiOperation(value = "查看所有区块")
    public ReturnMessage getAll() {
//        return new ReturnMessage(1, blockChain.getAllBlock());
        return null;
    }

}
