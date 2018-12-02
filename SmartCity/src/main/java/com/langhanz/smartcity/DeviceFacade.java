/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.smartcity;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author langhanz
 */
@Singleton
@Startup
public class DeviceFacade {
    
    List<Device> deviceList =  new ArrayList();//ejbFacade.findAll();
    
    
    public DeviceFacade(){
       
        deviceList.add(new Device(1, "0", -51.21, -30.08,"nada",1));
        deviceList.add(new Device(2, "0", -51.23, -30.09,"nada",1));
        deviceList.add(new Device(3, "0", -51.25, -30.10,"nada",1));
        deviceList.add(new Device(4, "0", -51.26, -30.11,"nada",1));
        deviceList.add(new Device(5, "0", -51.27, -30.12,"nada",1));
        deviceList.add(new Device(6, "0", -51.28, -30.13,"nada",1));
        
    }
    
    public Device find(int id){
        
        for(Device s:deviceList){
            if(s.getId() == id)
                return s;
        }
        return null;
    }
    
    public List<Device> findAll(){
        return deviceList;
    }
        
    
    
}
