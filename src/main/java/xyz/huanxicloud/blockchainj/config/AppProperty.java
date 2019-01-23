package xyz.huanxicloud.blockchainj.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: huanxi
 * @date: 2019/1/4 18:51
 * 应用启动配置
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperty {
    private String publicKey;
    private String privateKey;
    private String myIp; //当前节点IP
    private String nodeServer;//节点种子服务器

    public String getMyIp() {
        return myIp;
    }

    public void setMyIp(String myIp) {
        this.myIp = myIp;
    }

    public String getNodeServer() {
        return nodeServer;
    }

    public void setNodeServer(String nodeServer) {
        this.nodeServer = nodeServer;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
