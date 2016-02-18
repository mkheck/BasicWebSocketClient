/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thehecklers.websocketclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author mark
 */
public class MainMessage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MessageEndpoint endpoint = new MessageEndpoint();
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(endpoint, new URI("ws://localhost:8080/WebSocketServer/messages"));
            endpoint.SendMessage("Testing!");
        } catch (DeploymentException | IOException | URISyntaxException ex) {
            Logger.getLogger(MainMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
