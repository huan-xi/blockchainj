package xyz.huanxicloud.blockchainj.core.network.server;

import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author: huanxi
 * @date: 2019/1/21 20:55
 */
@ServerEndpoint(value = "/connect")
@Component
public class ServerSocket {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("客户端连接");
    }
}
