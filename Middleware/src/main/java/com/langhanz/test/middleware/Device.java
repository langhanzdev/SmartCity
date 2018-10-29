/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.test.middleware;

/**
 *
 * @author langhanz
 */
public class Device {
    
    private int idDevice;
    private String value;

    public Device(int idDevice, String value) {
        this.idDevice = idDevice;
        this.value = value;
    }
    
    

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Device{" + "idDevice=" + idDevice + ", value=" + value + '}';
    }
    
    
    
   
}
