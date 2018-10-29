/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.test.middleware;

import com.langhanz.middleware.websocket.Connector;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author langhanz
 */
@ApplicationScoped
@Named(value = "middlewareController")
public class MiddlewareController {
    
    private ArrayList<Device> deviceList = new ArrayList<>();
    
    @Inject Connector conn;
    
    public MiddlewareController(){
        
        deviceList.add(new Device(1, "50"));
        deviceList.add(new Device(2, "60"));
        deviceList.add(new Device(3, "20"));
        deviceList.add(new Device(4, "80"));
        deviceList.add(new Device(5, "90"));
        
        System.out.println("[Middleware] Sending devices...");
        for(Device d:deviceList){
            conn.sendMessage(d.toString());
        }
        System.out.println("[Middleware] Devices sent.");
        
    }
    
    
}
