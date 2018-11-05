/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.smartcity;

import com.langhanz.websocket.Middleman;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author langhanz
 */
@ApplicationScoped
@Named(value = "deviceController")
public class DeviceController {
    
    private ArrayList<Device> deviceList = new ArrayList<>();
    private ArrayList<String> messageList = new ArrayList<>();
    private ArrayList<String> notificationList = new ArrayList<>();
    
    @Inject Middleman mid;
    
    public void getMessages() throws InterruptedException{
        
        
       String event = mid.pollEvent(); 
 
       while(event != null){
            
            if(messageList.size() > 50){
                messageList.remove(messageList.size()-1);
            }
            
            messageList.add(0,event);
            System.out.println("[APP] Notification - "+messageList.get(0));
            event = mid.pollEvent(); 
        }
    }
    
    
    public void updateRoutine(){
        
        notificationList = messageList;
        System.out.println("[APP] lista "+notificationList.size());
    }

    public ArrayList<String> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(ArrayList<String> notificationList) {
        this.notificationList = notificationList;
    }
    

    
    
    
    
    
}
