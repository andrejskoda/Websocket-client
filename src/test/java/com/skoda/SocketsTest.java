/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skoda;

import com.skoda.websocket.client.MessagesEndpoint;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import org.junit.Test;

/**
 *
 * @author andrej
 */
public class SocketsTest {
    
    @Test
    public void sendMessage() throws DeploymentException, IOException, URISyntaxException{
        MessagesEndpoint endPoint = new MessagesEndpoint();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(endPoint, new URI("ws://localhost:8080/Websocket-server/messages"));
        endPoint.sendMessage("Hey dude!");
    }
}
