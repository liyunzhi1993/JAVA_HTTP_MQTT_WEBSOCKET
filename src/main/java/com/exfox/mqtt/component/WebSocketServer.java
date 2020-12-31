package com.exfox.mqtt.component;


import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //接收sid
    private String sid="";

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);
        this.sid=sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            System.out.println("Websocket IO异常");
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("连接关闭");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public void sendMessage(String message,String sid) throws IOException {
        //sid为空群发
        if(sid.equals(""))
        {
            for (WebSocketServer item : webSocketSet) {
                try {
                    item.sendMessage(message);
                } catch (IOException ignored) {
                }
            }
        }else {
            Optional<WebSocketServer> webSocketServerOptional = webSocketSet.stream().filter(x -> x.sid.equals(sid)).findFirst();
            if (webSocketServerOptional.isPresent()) {
                this.session=webSocketServerOptional.get().session;
                this.sendMessage(message);
            }
        }
    }
}
