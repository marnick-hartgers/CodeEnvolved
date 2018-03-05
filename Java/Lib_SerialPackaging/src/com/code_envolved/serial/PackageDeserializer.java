package com.code_envolved.serial;

import com.code_envolved.serial.models.TypeStaticValue;
import com.code_envolved.serial.models.ValueDictionary;

import java.nio.BufferOverflowException;
import java.util.EventListener;

public class PackageDeserializer {

    private final byte _startByte = (byte) 0xAA;
    private final ReceivedValueEventListner listner ;

    byte[] _readBuffer = new byte[2048];
    int _writeIndex = 0;
    int _readIndex = 0;

    public PackageDeserializer(ReceivedValueEventListner l) {
        listner = l;
    }

    private void readBytes(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {

            _readBuffer[_writeIndex] = bytes[i];
            _writeIndex++;
            if (_writeIndex > _readBuffer.length) {
                throw new BufferOverflowException();
            }
        }
        checkForData();
    }

    private void checkForData() {
        int startbyteIndex = -1;

        for (int readIndex = _readIndex; readIndex < _writeIndex; readIndex++) {
            if (startbyteIndex == -1 && _readBuffer[readIndex] == 0xAA) {
                startbyteIndex = readIndex;
            } else if (startbyteIndex == -1) {
                int length = tryReadPackage(startbyteIndex);
                _readIndex = startbyteIndex + length;
                startbyteIndex = -1;
            }

        }
    }

    private int tryReadPackage(int start) {
        if (_writeIndex - start > 6) {
            int packLength = parseUInt(_readBuffer[start + 1], _readBuffer[start + 2]);
            if (_writeIndex - start >= packLength) {
                parseValue(start + 3, _readIndex + packLength);
                return packLength;
            }
        }
        return 0;
    }

    private void parseValue(int begin, int end) {
        byte typebyte = _readBuffer[begin + 1];
        byte index = _readBuffer[begin];
        TypeStaticValue value = null;
        try {
            switch (typebyte) {
                case 0x0:
                    value = new TypeStaticValue(_readBuffer[begin + 3]);
                    break;
                case 0x1:
                    value = new TypeStaticValue(parseUInt(_readBuffer[begin + 3], _readBuffer[begin + 4]));
                    break;
                case 0x2:
                    value = new TypeStaticValue((char) _readBuffer[begin + 3]);
                    break;
                case 0x3:
                    value = new TypeStaticValue(parseString(begin + 3, end));
                    break;
            }
        }catch (Exception err){
            err.printStackTrace();
        }
        if(value != null){
            emitNewValue(index,value);
        }

    }

    private void emitNewValue(int index, TypeStaticValue v){
        listner.receivedValue(index, v);
    }

    private int parseUInt(byte highByte, byte lowByte) {
        return (int) lowByte + ((int) highByte << 8);
    }

    private String parseString(int begin, int end) {
        if (begin + 2 <= end || _writeIndex < end) {
            return "Parse error";
        }
        int length = parseUInt(_readBuffer[begin], _readBuffer[begin + 1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
                sb.append(_readBuffer[begin + 2 + i]);
        }
        return sb.toString();
    }

    public static class ReceivedValueEventListner implements EventListener {
        public void receivedValue(int index, TypeStaticValue value) {

        }
    }

}
