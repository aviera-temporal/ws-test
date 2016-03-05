package org.arielviera.tests.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import elemental.client.Browser;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.events.MessageEvent;
import elemental.html.WebSocket;

/**
 * Created by avd on 2016-02-29.
 */
public class Main implements EntryPoint {
    public void onModuleLoad() {

        final WebSocket webSocket = Browser.getWindow().newWebSocket(GWT.getHostPageBaseURL().replace("http", "ws")+"/ping");

        webSocket.setOnopen(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                Window.alert("open");

                webSocket.send("ping");
            }
        });

        webSocket.setOnmessage(new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                MessageEvent event = (MessageEvent) evt;
                Window.alert(event.getData().getClass().toString());
            }
        });


    }
}
