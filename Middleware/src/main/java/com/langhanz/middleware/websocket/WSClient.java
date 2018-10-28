/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.middleware.websocket;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


/**
 *
 * @author langhanz
 */
public class WSClient {
    
    public WSClient() {
    
        init();
        
    }
    
    public void connect(URI uri) throws DeploymentException, IOException {
        
      
             session =  container.connectToServer(WSCE1.class, uri);
       
         
    }
    
    public void sendStringMessage(String message) {
        
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(WSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void init() {
        
        container = ContainerProvider.getWebSocketContainer();
        
    }    
    
    
    private WebSocketContainer container;
    private Session session;
    
    
}
