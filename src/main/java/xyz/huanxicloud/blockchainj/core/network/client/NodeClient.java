package xyz.huanxicloud.blockchainj.core.network.client;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 节点客户端，监听节点变化
 * 连接节点种子服务器（带上自己地址，服务器广播有新的节点加入）,获取所有节点，并且与其相连
 * 接受服务器节点发生变化指令，新增或删除对应节点
 *
 * @author: huanxi
 * @date: 2019/1/23 11:42
 */
public class NodeClient {
    private NodeClient() {
    }

    private static Log log = LogFactory.get(NodeClient.class);
    private static NodeClient nodeClient;

    public void connectWithAllNode(List<String> ips) {
        for (String url : ips) {
            System.out.println("ws://" + url);
//            SocketClientManager.connectNode("ws://" + url);
        }
    }

    /**
     * 连接节点种子服务器
     *
     * @param nodeServer 种子服务器地址
     * @param myIp       我的地址
     */
    public void connectNodeServer(String nodeServer, String myIp) {
        Request request = new Request.Builder()
                .url(nodeServer + myIp)
                .build();
        SocketClientManager.getClient().newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                Instruction instruction = JSON.parseObject(text, Instruction.class);
                switch (instruction.type) {
                    case Instruction.InstructionType.ALL:
                        List<String> ips = (List<String>) instruction.msg;
                        connectWithAllNode(ips);
                        break;
                    case Instruction.InstructionType.ADD:
                        break;
                    case Instruction.InstructionType.REMOVE:
                        break;
                }
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
                System.out.println("连接关闭");
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, @Nullable Response response) {
                log.error("节点服务器连接异常");
                t.printStackTrace();
            }
        });
    }

    public static NodeClient getNodeClient() {
        if (nodeClient == null) nodeClient = new NodeClient();
        return nodeClient;
    }
}
