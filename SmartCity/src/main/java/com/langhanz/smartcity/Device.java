/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.smartcity;

import java.util.ArrayList;

/**
 *
 * @author langhanz
 */
public class Device {
    
    private int id;
    private String value;
    private int type;
    private double lon;
    private double lat;
    private String address;
    private ArrayList<String> values;
    private String domain;
    private int groups;

    public Device(int id, String value, double lon, double lat, String address, int type, String domain, int groups) {
        this.id = id;
        this.value = value;
        this.lon = lon;
        this.lat = lat;
        this.address = address;
        this.type = type;
        this.values = new ArrayList<>();
        this.domain = domain;
        this.groups = groups;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public void setNewValue(String v){
        if(values.size() > 9){
            values.remove(0);
        }
        values.add(v);
        setValue(value);
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }
    
    public String toStringJson(){
        return "{\"id\":\""+id+"\",\"value\":\""+value+"\",\"lon\":\""+lon+"\",\"lat\":\""+lat+"\",\"type\":\""+type+"\",\"domain\":\""+domain+"\",\"groups\":\""+groups+"\"}";
    }
}
