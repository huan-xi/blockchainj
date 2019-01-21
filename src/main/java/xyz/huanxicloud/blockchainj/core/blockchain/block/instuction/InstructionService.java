package xyz.huanxicloud.blockchainj.core.blockchain.block.instuction;

import org.springframework.stereotype.Service;
import xyz.huanxicloud.blockchainj.core.common.AppProperty;
import xyz.huanxicloud.blockchainj.core.common.encrypt.TrustSDK;
import xyz.huanxicloud.blockchainj.core.common.encrypt.exception.TrustSDKException;
import xyz.huanxicloud.blockchainj.core.common.util.CommonUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @author: huanxi
 * @date: 2019/1/4 18:59
 */
@Service
public class InstructionService {
    @Resource
    AppProperty appProperty;

    public Instruction build(String json) {
        Instruction instruction = new Instruction();
        instruction.setContent(json);
        instruction.setInputKey(appProperty.getPublicKey());
        instruction.setTimeStamp(CommonUtils.getTimestamp());
        //用私钥签名(指令hash)让供别人验证
        try {
            instruction.setSign(TrustSDK.signString(appProperty.getPrivateKey(), instruction.getHash()));
        } catch (TrustSDKException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return instruction;
    }
}
