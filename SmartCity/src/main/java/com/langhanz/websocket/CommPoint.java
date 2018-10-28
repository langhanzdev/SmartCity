/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.websocket;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import com.langhanz.connector.StrMessage;

/**
 * This class is a WebSocket Endpoint that receive messages and send commands to devices.
 * @author langhanz
 */

@ApplicationScoped
@ServerEndpoint("/cp1")
public class CommPoint {
        
    @Inject
    Middleman mid;

    /**
     * Called when is open a new WebSocket connection.
     * @param session
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        
        System.out.println("[APP][CommPoint onOpen: " + session.getId());
        tryConnect(session);
    }
    
    /**
     * Called when is received a new message in the WebSocket.
     * @param session
     * @param message
     * @throws IOException 
     */
    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        
        Session client = mid.getSession(1);
        
        if(client == null && !tryConnect(session)) 
            return;     
        
        if(!session.equals(client)){
            System.out.println("[APP][CommPoint onMessage: Invalid client.");
            return;
        }
        
        System.out.println("[APP][CommPoint onMessage: " + message);      
        mid.registerEvent(message);
               
    }
    
    /**
     * Called when occurred a error in WebSocket.
     * @param session
     * @param t 
     */
    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("[APP] Error in WebSocket communication: " + t.getMessage());       
    }
    
    /**
     * Called when a connection is closed.
     * @param session
     * @param reason 
     */
    @OnClose
    public void onClose (Session session, CloseReason reason) {
        
        System.out.println("[APP]Client disconnected...:" + reason.getReasonPhrase());
        
        mid.unregisterClient(session);
        
    }
    
    /**
     * This method send the command for the device.
     * @param sm Command string to be sends.
     * @throws IOException 
     */
    public void sendMessage(@Observes @Any String sm) throws IOException {
        
        Session cSession = mid.getSession(1);
        
        if (cSession != null) {
            System.out.println("[APP] SEND TO MIDDLEWARE: " + sm + " " + cSession.getId());        
            cSession.getBasicRemote().sendText(sm.toString());          
        }else{ 
            System.out.println("[APP] SEND | MIDDLEWARE " + sm + " IS NOT ACTIVE!" );
        }
    }
 
    /**
     * Called when a client (device) try connect in the WebSocket.
     * @param session Client Session
     * @return If the connection was established with success.
     * @throws IOException 
     */
    private boolean tryConnect(Session session) throws IOException{
        if(mid.registerNewClient(session)){
            System.out.println("[APP][CommPoint onOpen: Successfully added client.");
            return true;
        }else{
            System.out.println("[APP][CommPoint onOpen: New client not added.");
            
            session.getBasicRemote().sendText("[APP]Connection refused: There is already a connected client.");
        }
        return false;
    }
    
}
