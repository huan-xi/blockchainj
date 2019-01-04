package xyz.huanxicloud.blockchainj.core.blockchain.block;

import xyz.huanxicloud.blockchainj.core.blockchain.block.instuction.Instruction;

import java.util.List;

/**
 * @author: huanxi
 * @date: 2019/1/1 17:57
 * 区块体
 */
public class BlockBody {
    private List<Instruction> instructions;

    @Override
    public String toString() {
        return "BlockBody{" +
                "instructions=" + instructions +
                '}';
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}
