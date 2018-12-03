/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.langhanz.smartcity;

import com.langhanz.websocket.Middleman;
import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;



/**
 *
 * @author langhanz
 */
@ApplicationScoped
@Named(value = "deviceController")
public class DeviceController {
    
    private ArrayList<Device> deviceList = new ArrayList<>();
    private ArrayList<String> messageList = new ArrayList<>();
    private ArrayList<String> notificationList = new ArrayList<>();
    private Device currentDevice;
    
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private LineChartModel zoomModel;
    private LineChartModel animatedModel1;
    private LineChartModel multiAxisModel;
    private LineChartModel dateModel;
    
    @Inject com.langhanz.smartcity.DeviceFacade devFacade;
    
    
    @Inject Middleman mid;
    
    @PostConstruct
    public void init(){
        createLineModels();
    }
    
    public void getMessages() throws InterruptedException{
        
        
       String event = mid.pollEvent(); 
 
       while(event != null){
            
            if(messageList.size() > 50){
                messageList.remove(messageList.size()-1);
            }
            
            messageList.add(0,event);
            System.out.println("[APP] Notification - "+messageList.get(0));
            event = mid.pollEvent(); 
        }
    }
    
    
    public void updateRoutine(){
        
        notificationList = messageList;
        System.out.println("[APP] lista "+notificationList.size());
        Random rand = new Random();
        int val = rand.nextInt(100);
        if(val > 20 && val < 40){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO: Notification Received","A Device sent a message.")); 
        }
        if(val >= 40 && val < 90){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING: Notification Received.","A Device sent warning message.")); 
        }
        if(val > 90){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR: Notification Received.","A Device sent error message.")); 
        }
    }

    public ArrayList<String> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(ArrayList<String> notificationList) {
        this.notificationList = notificationList;
    }
    

    public void onSelectDevice(Device device){
        
        currentDevice = device;
        
        
    }

    public Device getCurrentDevice() {
        return currentDevice;
    }

    public void setCurrentDevice(Device currentDevice) {
        this.currentDevice = currentDevice;
    }
    
    
    
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
    
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
   
 
    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }
 
    public LineChartModel getDateModel() {
        return dateModel;
    }
    
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
 
        return model;
    }
 
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setStacked(false);
        //lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(-20);
        yAxis.setMax(50);
       
 
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
 
        zoomModel = initLinearModel();
        zoomModel.setTitle("Zoom");
        zoomModel.setZoom(true);
        zoomModel.setLegendPosition("e");
        yAxis = zoomModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
 
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
       
 
        model.addSeries(series1);
        
 
        return model;
    }
    
    
    public void commandGetTemperature(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Command Get Temperature.","Command sent successfully.")); 
    }
    
    
}
