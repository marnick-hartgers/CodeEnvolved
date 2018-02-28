package com.code_envolved.serial.models;

public abstract class  ValueDictionary {

    private final TypeStaticValue[] values = new TypeStaticValue[256];

        public ValueDictionary(){

        }

        protected void setValue(int index, TypeStaticValue value){
            values[index] = value;
        }

        public TypeStaticValue getValue(int index){
            return values[index];
        }

}
