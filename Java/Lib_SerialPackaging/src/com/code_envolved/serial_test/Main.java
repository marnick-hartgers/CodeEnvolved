package com.code_envolved.serial_test;

import com.code_envolved.serial.ArduinoSerialCom;
import com.code_envolved.serial.models.ValueDictionary;
import jssc.SerialPortException;

import java.io.Console;

public class Main {
    private ArduinoSerialCom serial = null;

    public static void main(String[] args){
        Main m = new Main();
        m.printComList();
        m.connect();
        Console c = System.console();
        c.readLine();
    }

    public Main(){

    }

    public void printComList(){
        String[] ports = ArduinoSerialCom.getPorts();
        for(int i=0;i<ports.length;i++){
            System.out.println(i+ ": " + ports[i]);
        }
    }

    public void connect(){
        String[] ports = ArduinoSerialCom.getPorts();
        if(ports.length > 0){
            connectToPort(ports[0]);
        }

    }

    public void connectToPort(String name){
        serial = new ArduinoSerialCom(name);
        serial.setValueColelctionChangedEventLister(new ValueDictionary.ValueColelctionChangedEventLister(){
            @Override
            public void onCollecionChanged(int index) {
                super.onCollecionChanged(index);
                System.out.println(serial.getValue(index).toString());
            }
        });
        try {
            serial.open();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

}
