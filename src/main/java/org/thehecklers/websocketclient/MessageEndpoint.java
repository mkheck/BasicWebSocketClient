/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thehecklers.websocketclient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 *
 * @author mark
 */
public class MessageEndpoint extends Endpoint {
    private Session session;
    
    @Override
    public void onOpen(Session sn, EndpointConfig ec) {
        this.session = sn;
        this.session.addMessageHandler((MessageHandler.Whole<String>) (String t) -> {
            System.out.println("Message = " + t);
        });
    }

//    @Override
//    public void onMessage() {
//        
//    }
    
    public void SendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(MessageEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
