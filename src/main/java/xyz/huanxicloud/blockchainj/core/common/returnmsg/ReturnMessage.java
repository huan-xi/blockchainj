package xyz.huanxicloud.blockchainj.core.common.returnmsg;

/**
 * @author wuweifeng wrote on 2017/10/23.
 */
public class ReturnMessage {
    private int code;
    private Object msg;

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "code=" + code +
                ", data=" + msg +
                '}';
    }

    public ReturnMessage(int code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnMessage setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ReturnMessage setCode(int code) {
        this.code = code;
        return this;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
