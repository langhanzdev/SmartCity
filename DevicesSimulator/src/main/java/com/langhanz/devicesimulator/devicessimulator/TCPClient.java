/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.devicesimulator.devicessimulator;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author langhanz
 */
public class TCPClient {
    public static void main(String[] args) {
    try {
      Socket cliente = new Socket("paulo",12345);
      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
      Date data_atual = (Date)entrada.readObject();
        System.out.println("[Simulator] Data recebida do servidor:" + data_atual.toString());
      entrada.close();
      System.out.println("[Simulator] Conexão encerrada");
    }
    catch(Exception e) {
      System.out.println("[Simulator] Erro: " + e.getMessage());
    }
  }
}
