package com.code_envolved.serial.models;

import javax.naming.OperationNotSupportedException;

public class TypeStaticValue {
    private final StaticType type;
    private byte byteValue;
    private char charValue;
    private int intValue;
    private String stringValue = null;

    public TypeStaticValue(byte value) {
        type = StaticType.BYTE;
        byteValue = value;
    }

    public TypeStaticValue(int value) {
        type = StaticType.INT;
        intValue = value;
    }

    public TypeStaticValue(char value) {
        type = StaticType.CHAR;
        charValue = value;
    }

    public TypeStaticValue(String value) {
        type = StaticType.STRING;
        stringValue = value;
    }

    public StaticType getType() {
        return type;
    }

    public byte getByteValue() throws InvalTypeExeption {
        if (type != StaticType.BYTE) {
            throw new InvalTypeExeption(StaticType.BYTE);
        }
        return byteValue;
    }

    public int getIntValue() throws InvalTypeExeption {
        if (type != StaticType.INT) {
            throw new InvalTypeExeption(StaticType.INT);
        }
        return intValue;
    }

    public char getCharValue() throws InvalTypeExeption {
        if (type != StaticType.CHAR) {
            throw new InvalTypeExeption(StaticType.CHAR);
        }
        return charValue;
    }

    public String getStringValue() throws InvalTypeExeption {
        if (type != StaticType.STRING) {
            throw new InvalTypeExeption(StaticType.STRING);
        }
        return stringValue;
    }

    enum StaticType {
        BYTE, INT, CHAR, STRING
    }

    class InvalTypeExeption extends Exception {
        InvalTypeExeption(StaticType type) {
            super("The value has not the type: " + type.name());
        }
    }

    @Override
    public String toString() {
        try {
            switch (type) {
                case BYTE:
                    return "Byte: " + getByteValue();
                case INT:
                    return "Byte: " + getIntValue();
                case CHAR:
                    return "Byte: " + getCharValue();
                case STRING:
                    return "Byte: " + getStringValue();

            }
        } catch (InvalTypeExeption invalTypeExeption){
            invalTypeExeption.printStackTrace();
        }
        return "";
    }

}


