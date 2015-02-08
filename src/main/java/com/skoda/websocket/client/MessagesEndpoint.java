/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skoda.websocket.client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 *
 * @author andrej
 */
public class MessagesEndpoint extends Endpoint{
    private Session session;

    @Override
    public void onOpen(Session sn, EndpointConfig ec) {
        this.session = sn;
        this.session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String t) {
                System.out.println("Message= "+t);
            }
        });
    }
    
    public void sendMessage(String message){
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(MessagesEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
