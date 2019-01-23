package xyz.huanxicloud.blockchainj.core.network.client;


public class Instruction {
    public interface InstructionType {
        public static final int ALL = 0;
        public static final int ADD = 1;
        public static final int REMOVE = 2;
    }

    public Instruction() {
    }

    public Instruction(int type, Object msg) {
        this.type = type;
        this.msg = msg;
    }

    int type;
    Object msg;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
