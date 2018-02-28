package com.code_envolved.serial.models;

public abstract class  ValueDictionary {

    private final TypeStaticValue[] values = new TypeStaticValue[256];

        public ValueDictionary(){

        }

        protected void setValue(int index, byte value){
            values[index] = new TypeStaticValue(value);
        }
        protected void setValue(int index, int value){
            values[index] = new TypeStaticValue(value);
        }
        protected void setValue(int index, char value){
            values[index] = new TypeStaticValue(value);
        }
        protected void setValue(int index, String value){
            values[index] = new TypeStaticValue(value);
        }

        public TypeStaticValue getValue(int index){
            return values[index];
        }

}
