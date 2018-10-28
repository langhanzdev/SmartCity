/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.middleware.websocket;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author langhanz
 */
public class SerialWriter implements Runnable {
 
    OutputStream out;
    
    byte tx_base[]= {(byte)0xfa, (byte)0x40, (byte)0x04, (byte)0x00, (byte)0x00, (byte)0xfe};
    
    byte tx[]= {0x02, 0x20};
 
    public SerialWriter( OutputStream out ) {
      this.out = out;
    }
 
    public void run() {
     
        try {
          this.out.write( tx_base[0] );
          this.out.write( tx_base[1] );
          this.out.write( tx_base[2] );
          this.out.write( tx_base[3] );
          this.out.write( tx_base[4] );
          this.out.write( tx_base[5] );
          Thread.sleep(500);
          this.out.write( tx_base[0] );
          this.out.write( tx_base[1] );
          this.out.write( tx_base[2] );
          this.out.write( tx_base[3] );
          this.out.write( tx_base[4] );
          this.out.write( tx_base[5] );
          Thread.sleep(500);
          this.out.write( tx_base[0] );
          this.out.write( tx_base[1] );
          this.out.write( tx_base[2] );
          this.out.write( tx_base[3] );
          this.out.write( tx_base[4] );
          this.out.write( tx_base[5] );
          Thread.sleep(500);
          
        } catch (IOException ex) {
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) { 
        try {
                    
          this.out.write( tx[0] );
          this.out.write( tx[1] );
          Thread.sleep(1000);
        
      } catch( IOException e ) {
        e.printStackTrace();
      } catch (InterruptedException ex) {
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
  }
 