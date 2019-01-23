package xyz.huanxicloud.blockchainj.core.network.client;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import okhttp3.*;
import xyz.huanxicloud.blockchainj.core.network.server.SocketServer;

/**
 * @author: huanxi
 * @date: 2019/1/21 21:37
 */
public class SocketClient {
    private static Log log = LogFactory.get(SocketClient.class);

    public static void main(String[] args) {
        String host = "192.168.99.141:8080";
        String url = "ws://" + host + "/connect";
        OkHttpClient client = new OkHttpClient.Builder().build();
        //连接
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                System.out.println("test");
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
}
