package com.code_envolved.serial;

import com.code_envolved.serial.models.TypeStaticValue;
import com.code_envolved.serial.models.ValueDictionary;
import jssc.*;

public class ArduinoSerialCom  extends ValueDictionary implements SerialPortEventListener {
    private SerialPort port;
    private PackageDeserializer _deserializer;

    public static String[] getPorts(){
        return SerialPortList.getPortNames();
    }

    public ArduinoSerialCom(String portName){
        super();
        port = new SerialPort(portName);
        _deserializer = new PackageDeserializer(new PackageDeserializer.ReceivedValueEventListner(){
            @Override
            public void receivedValue(int index, TypeStaticValue value) {
                super.receivedValue(index, value);
                setValue(index, value);
            }
        });
    }


    public void open() throws SerialPortException {
        port.openPort();
        port.setParams(9600, 8, 1, 0);
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
