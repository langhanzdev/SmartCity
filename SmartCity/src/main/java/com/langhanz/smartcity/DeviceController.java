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
    
    @Inject Middleman mid;
    
    
    private ArrayList<String> notificationList = new ArrayList<>();

    
    
    public void getMessages() throws InterruptedException{
        
        
       String event = mid.pollEvent(); 
 
       while(event != null){
            
            if(notificationList.size() > 50){
                notificationList.remove(notificationList.size()-1);
            }
            
            notificationList.add(0,event);
            System.out.println("[APP] Notification - "+notificationList.get(0));
            event = mid.pollEvent(); 
        }
    }
    
    
}
