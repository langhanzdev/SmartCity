/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.cdi;

import com.langhanz.connector.StrManip;
import com.langhanz.connector.StrMessage;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author langhanz
 */
@ApplicationScoped
@Named(value = "mapController")
public class MapController {
    @Inject @Any Event<String> ev;
    
    public void sendMessage(){
        String msg = "ENVIANDO MENSAGEM ";
        
        System.out.println(msg);

            ev.fire(msg);
    }
}
