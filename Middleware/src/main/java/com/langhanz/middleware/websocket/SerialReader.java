/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.middleware.websocket;

import java.io.IOException;
import java.io.InputStream;


/**
 *
 * @author langhanz
 */
 public class SerialReader implements Runnable {

    WSClient wsClient;
    
    InputStream in;
 
    public SerialReader( InputStream in, WSClient wsc ) {
      this.in = in;
      this.wsClient = wsc;
    }
 
    public void run() {
        
      boolean start_decoding  = false;
      boolean decoded  = false;
      String message = null;
    
        
      byte[] buffer = new byte[ 167 ];
      int len = -1;
      try {
        while( ( len = this.in.read( buffer ) ) > -1 ) {
          
            String messageRecv = new String( buffer, 0, len );
            
            System.out.println( "messageRecv" );
            System.out.println( "" );
            //wsClient.sendStringMessage(messageRecv);
            
        }
      } catch( IOException e ) {
        e.printStackTrace();
      }
      
      
      
    }
  }