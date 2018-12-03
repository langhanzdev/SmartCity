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
       
        deviceList.add(new Device(1, "ON", -51.18730, -30.05643,"Av. Ipiranga",0,"Ilumination",1));
        deviceList.add(new Device(2, "ON", -51.19043, -30.05472,"Av. Ipiranga",0,"Ilumination",1));
        deviceList.add(new Device(3, "ON", -51.19296, -30.05316,"Av. Ipiranga",0,"Ilumination",1));
        deviceList.add(new Device(4, "ON", -51.19476, -30.05078,"Av. Ipiranga",0,"Ilumination",1));
        deviceList.add(new Device(5, "ON", -51.19631, -30.04874,"Av. Ipiranga",0,"Ilumination",1));
        deviceList.add(new Device(6, "ON", -51.19781, -30.04677,"Av. Ipiranga",0,"Ilumination",1));
        
        
        deviceList.add(new Device(7, "23.5", -51.18408, -30.05769,"Cruazamento",1,"Meteorology",1));
        deviceList.add(new Device(8, "24.7", -51.16919, -30.05565,"Cruazamento",1,"Meteorology",1));
        deviceList.add(new Device(9, "24.5", -51.20429, -30.04324,"Cruazamento",1,"Meteorology",1));
        deviceList.add(new Device(10, "24.6", -51.20403, -30.03785,"Cruazamento",1,"Meteorology",1));
        deviceList.add(new Device(11, "24.1", -51.17391, -30.03874,"Cruazamento",1,"Meteorology",1));
        
        
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
