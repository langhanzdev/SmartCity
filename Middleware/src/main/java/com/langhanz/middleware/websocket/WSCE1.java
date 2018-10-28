/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.middleware.websocket;

import java.io.IOException;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author langhanz
 */

@ClientEndpoint
public class WSCE1 {
    
    @OnOpen
    public void onOpen(Session session) throws IOException {
        
       System.out.println("Client connected...:" + session.getId());
        
    }
    
    @OnMessage
    public String onMessage(Session session, String message) {
        
        System.out.println("Message received: " + message);
        
        return null;
    }
    
    @OnError
    public void onError(Session session, Throwable t) {
        
        
    }
    
    @OnClose
    public void onClose (Session session, CloseReason reason) {
        
        System.out.println("Client disconnected...:" + reason.getReasonPhrase());
        
    }
    
}
