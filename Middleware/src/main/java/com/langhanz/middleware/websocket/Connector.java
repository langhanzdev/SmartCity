/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.middleware.websocket;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.DeploymentException;


/**
 *
 * @author langhanz
 */
@Singleton
@Startup
public class Connector {
    
    private WSClient wsClient;

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    @PostConstruct
    public void start() {
        
        
        wsClient = new WSClient();
        try {
            System.out.println("[Middleware] Try connect...");
////            wsClient.connect(new URI("ws://192.168.160.6:8080/cosvc/cp1"));
            wsClient.connect(new URI("ws://localhost:8080/SmartCity-1.0-SNAPSHOT/cp1"));
            
            
            wsClient.sendStringMessage("REG|001;");
            Thread.sleep(2000);
            wsClient.sendStringMessage("TESTE 1;");
            Thread.sleep(2000);
            wsClient.sendStringMessage("Teste2;");
            
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DeploymentException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex){
            
        }
        
        
        //while (true) {
        
            //Light
//            wsClient.sendStringMessage("REG|001;");
//            wsClient.sendStringMessage("REG|002;");
//            wsClient.sendStringMessage("REG|003;");
              

        //}
        
        
       
        /*
        try 
        {
        
            (new TwoWaySerialComm()).connect("/dev/ttyS2",null);
            //(new TwoWaySerialComm()).connect("/dev/ttyS1",null);
            
            
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                */
                           
    }
    
    
    public void sendMessage(String msg){
        wsClient.sendStringMessage(msg);
    }
    
    
    
}
