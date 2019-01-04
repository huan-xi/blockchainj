package xyz.huanxicloud.blockchainj.core.blockchain.block.instuction;

/**
 * blockBody内一条指令的基础属性
 */
public class InstructionBase {
    /**
     * 指令的操作，增删改（1，-1，2）
     */
    private byte operation;
    /**
     * 操作的表名
     */
    private String table;
    /**
     * 最终要执行入库的json内容
     */
    private String oldJson;
    /**
     * 业务id，sql语句中where需要该Id
     */
    private String instructionId;

    public byte getOperation() {
        return operation;
    }

    public void setOperation(byte operation) {
        this.operation = operation;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getOldJson() {
        return oldJson;
    }

    public void setOldJson(String oldJson) {
        this.oldJson = oldJson;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    @Override
    public String toString() {
        return "InstructionReverse{" +
                "operation=" + operation +
                ", table='" + table + '\'' +
                ", oldJson='" + oldJson + '\'' +
                ", instructionId='" + instructionId + '\'' +
                '}';
    }
}
