package xyz.huanxicloud.blockchainj.core.network.server;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.stereotype.Component;
import xyz.huanxicloud.blockchainj.core.blockchain.block.Block;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: huanxi
 * @date: 2019/1/21 20:55
 * 服务端启动
 */
@ServerEndpoint(value = "/connect")
@Component
public class SocketServerManager {

    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<Session>();
    private static Log log = LogFactory.get(SocketServerManager.class);

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        log.info("有节点连接，当前连接节点总数：" + sessions.size());
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        log.info("有节点断开,当前连接节点数：" + sessions.size());
    }

    @OnError
    public void error(Session session, Throwable t) {
        log.info("有节点发生错误");
    }

    public void broadcastBlock(Block block) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(block.toString());
            } catch (IOException e) {
                log.info("广播失败");
                e.printStackTrace();
            }
        }
    }
}
