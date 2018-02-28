package com.code_envolved.serial;

import com.code_envolved.serial.models.ValueDictionary;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class ArduinoSerialCom  extends ValueDictionary implements SerialPortEventListener {
    private SerialPort port;

    public ArduinoSerialCom(String portName){
        super();
        port = new SerialPort(portName);
    }


    public void open() throws SerialPortException {
        port.openPort();
        port.addEventListener(this);
    }

    public void close() throws SerialPortException {
        port.closePort();
        port.removeEventListener();
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if(serialPortEvent.isRXCHAR()){
            try {
                byte[] data = port.readBytes();

            } catch (SerialPortException e) {
                e.printStackTrace();
            }
        }

    }
}
