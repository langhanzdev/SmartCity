/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.smartcity;

import com.langhanz.websocket.Middleman;
import java.util.ArrayList;

import javax.inject.Inject;

/**
 *
 * @author langhanz
 */

public class MessageController {
    
   
    private ArrayList<String> messageList = new ArrayList<>();
    private ArrayList<String> notificationList = new ArrayList<>();
    
    
    public ArrayList<String> getNotifications(){
        return notificationList;
    }
}
