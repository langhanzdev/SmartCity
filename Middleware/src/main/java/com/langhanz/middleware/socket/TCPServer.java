/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.middleware.socket;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;


/**
 *
 * @author langhanz
 */
@Singleton
@Startup
public class TCPServer {
    
    @PostConstruct
    public void server() {
    try {
      // Instancia o ServerSocket ouvindo a porta 12345
      ServerSocket servidor = new ServerSocket(12345);
      System.out.println("[Middleware] Servidor ouvindo a porta 12345");
      while(true) {
        // o método accept() bloqueia a execução até que
        // o servidor receba um pedido de conexão
        Socket cliente = servidor.accept();
        System.out.println("[Middleware] Cliente conectado: " + cliente.getInetAddress().getHostAddress());
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        saida.flush();
        saida.writeObject(new Date());
        saida.close();
        cliente.close();
      }  
    }   
    catch(Exception e) {
       System.out.println("[Middleware] Erro: " + e.getMessage());
    }
    finally {
        System.out.println("[Middleware] Finalizando socket");
    }  
  }   
    
    
}
