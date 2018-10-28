/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.websocket;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.websocket.Session;
//import net.iotll.cityos.cosvc.presentation.MessageLogger;

/**
 * This class handles the events generated by WebSocket.
 * @author langhanz
 */

@Singleton
public class Middleman {
    
    Map<String,Session> clientList = new HashMap<String,Session>();
    Session client;
    
    private LinkedList<String> infoQueue = new LinkedList(); 
    private LinkedList<String> notificationQueue = new LinkedList();
    
    
    public Middleman () {}
    
    /**
     * Register new client WebSocket.
     * @param wsId Client session
     * @return If the add operation was a success.
     */
    public boolean registerNewClient(Session wsId) {

        String naturalId = "001"; // TODO mudar para lista, para nao precisar mais disso
        System.out.println("[Middleman - register new client] - wsId: "+wsId + " naturalId: " + naturalId );
        
        if(clientList.isEmpty()){
            clientList.put(naturalId, wsId);
            System.out.println("[Middleman - clientList] : " + clientList.size());
            return true;
        }
        
        System.out.println("[Middleman - clientList] : Client connection refused! Only one client is allowed at a time.");
        return false;  
    }
    
    /**
     * Remove client WebSocket.
     * @param wsId Session to be removed.
     */
    public void unregisterClient(Session wsId){

        String found = null;
 
        for (Map.Entry<String, Session> entry : clientList.entrySet()) {      
            if (entry.getValue().equals(wsId)) {
                System.out.println("FOUND: " + entry.getKey() );
                found = entry.getKey();
                break;
            } 
        }
        
        if (found != null) clientList.remove(found);
        System.out.println("[Middleman - client removed");
        System.out.println("[Middleman - clientList] : 0");
    }
    
    /**
     * Return the session of the connection.
     * @param naturalId Session Id.
     * @return Connection session.
     */
    public Session getSession(String naturalId) {      
        return clientList.get(naturalId);           
    }
            
    /**
     * Save the new event received.
     * @param message Received message.
     */
    public void registerEvent(String message) {
        
        System.out.println("[Middleman - NEW EVENT: " + message);
        infoQueue.add(message);
        notificationQueue.add(message);
    }
    
    /**
     * Returns the next event of the events queue received by WebSocket.
     * @return String received event.
     * @throws InterruptedException 
     */
    public String pollEvent() throws InterruptedException{       
        return infoQueue.poll();
    }
    
    /**
     * Returns the next notification of the message queue received by WebSocket.
     * @return String received message.
     */
    public String pollNotification(){
        return notificationQueue.poll();
    }
    
}