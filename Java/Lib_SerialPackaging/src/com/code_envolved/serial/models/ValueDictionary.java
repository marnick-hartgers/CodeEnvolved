package com.code_envolved.serial.models;

import java.util.EventListener;

public abstract class ValueDictionary {

    private final TypeStaticValue[] _values = new TypeStaticValue[256];

    private ValueColelctionChangedEventLister _lister = null;

    public ValueDictionary() {

    }

    public void setValueColelctionChangedEventLister(ValueColelctionChangedEventLister l){
        _lister = l;
    }

    protected void setValue(int index, byte value) {
        _values[index] = new TypeStaticValue(value);
        triggerListner(index);
    }

    protected void setValue(int index, int value) {
        _values[index] = new TypeStaticValue(value);
        triggerListner(index);
    }

    protected void setValue(int index, char value) {
        _values[index] = new TypeStaticValue(value);
        triggerListner(index);
    }

    protected void setValue(int index, String value) {
        _values[index] = new TypeStaticValue(value);
        triggerListner(index);
    }

    protected void setValue(int index, TypeStaticValue value) {
        _values[index] = value;
        triggerListner(index);
    }

    public TypeStaticValue getValue(int index) {
        return _values[index];
    }

    private void triggerListner(int index){
        if(_lister != null){
            _lister.onCollecionChanged(index);
        }
    }

    public static class ValueColelctionChangedEventLister implements EventListener{
        public void onCollecionChanged(int index){

        }
    }

}
