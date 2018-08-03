package com.chenjie.springbootwebsocket.service;

import com.chenjie.springbootwebsocket.vo.MessageVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author chenjie
 * @Date 2018/8/3 11:22
 * @Description: websocket
 */
@Component
@ServerEndpoint("websocket")
@Slf4j
public class WebSocketServer {

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSockets = new CopyOnWriteArraySet<>();

    /**
     * 消息实体
     */
    private MessageVo messageVo = new MessageVo();


    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);


        messageVo.setType(1);
        messageVo.setUserNum(webSockets.size());
        messageVo.setMessage("有新的连接");

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVo);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        this.sendMessage(Json);
        log.info("【websocket消息】有新的连接, 总数:{}", webSockets.size());
    }


    @OnClose
    public void onClose() {
        webSockets.remove(this);

        messageVo.setType(2);
        messageVo.setUserNum(webSockets.size());
        messageVo.setMessage("有用户离开");

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVo);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        this.sendMessage(Json);


        log.info("【websocket消息】连接断开, 总数:{}", webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {

        messageVo.setType(3);
        messageVo.setUserNum(webSockets.size());
        messageVo.setMessage(message);

        ObjectMapper mapper = new ObjectMapper();

        String Json = "";
        try {
            Json = mapper.writeValueAsString(messageVo);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        this.sendMessage(Json);

        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocketServer webSocket : webSockets) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
