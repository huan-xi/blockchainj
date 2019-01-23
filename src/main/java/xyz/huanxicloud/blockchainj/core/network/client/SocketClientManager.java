package xyz.huanxicloud.blockchainj.core.network.client;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import okhttp3.*;
import org.springframework.stereotype.Component;
import xyz.huanxicloud.blockchainj.config.AppProperty;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: huanxi
 * @date: 2019/1/21 21:37
 */
@Component
public class SocketClientManager {
    private static Log log = LogFactory.get(SocketClientManager.class);
    /**
     * 客户端连接set
     * 处理个节点广播消息
     */
    private static ConcurrentHashMap<WebSocket, String> clients = new ConcurrentHashMap<>();
    private static OkHttpClient client = new OkHttpClient.Builder().build();
    @Resource
    private AppProperty appProperty;

    public static void connectNode(String host) {
        log.info("开始连接节点" + host);
        String url = "ws://" + host + "/connect";
        //连接
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                clients.put(webSocket, host);
                log.info("连接节点成功，当前节点总数：" + clients.size());
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
                clients.remove(webSocket);
                log.info("有节点断开，当前节点总数：" + clients.size());
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                log.info("收到消息：" + text);
                //收到区块消息
                //进入投票
                //收到投票消息
                //达到共识，执行智能合约
            }
        });
    }

    public void start() {
        NodeClient.getNodeClient().connectNodeServer(appProperty.getNodeServer(), appProperty.getMyIp());
    }

    public static ConcurrentHashMap<WebSocket, String> getClients() {
        return clients;
    }

    public static OkHttpClient getClient() {
        return client;
    }
}
