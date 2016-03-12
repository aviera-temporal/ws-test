package org.arielviera.tests;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author ariel.viera@gmail.com (Ariel Viera)
 */
@ServerEndpoint("/ping2")
public class WebSocketEndpoint2 {
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        System.out.println("websocket opened : "+session.getId());
    }

    @OnMessage
    public void onMessage(String txt){
        try {
            this.session.getBasicRemote().sendText("pong2");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
