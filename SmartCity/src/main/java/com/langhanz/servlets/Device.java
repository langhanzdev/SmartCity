/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author langhanz
 */
@WebServlet("/devices/*")
public class Device extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<String> deviceList =  new ArrayList();//ejbFacade.findAll();
        deviceList.add("{\"elemento\": \"1\", \"longitude\": \"-51.21\", \"latitude\": \"-30.08\"}");
        deviceList.add("{\"elemento\": \"2\"}, \"longitude\": \"-51.23\", \"latitude\": \"-30.10\"}");
        deviceList.add("{\"elemento\": \"3\"}, \"longitude\": \"-51.25\", \"latitude\": \"-30.12\"}");
        deviceList.add("{\"elemento\": \"4\"}, \"longitude\": \"-51.27\", \"latitude\": \"-30.14\"}");
        deviceList.add("{\"elemento\": \"5\"}, \"longitude\": \"-51.29\", \"latitude\": \"-30.16\"}");
        deviceList.add("{\"elemento\": \"6\"}, \"longitude\": \"-51.31\", \"latitude\": \"-30.18\"}");
        String c;
        if(deviceList.isEmpty()){
            c = "[]";
        }else{
            c = "[";
            for(int i=0;i<=deviceList.size()-2;i++){
                c += deviceList.get(i) + ",";
            }
            c += deviceList.get(deviceList.size()-1);
            c+= "]";

        }
       
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(c);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
