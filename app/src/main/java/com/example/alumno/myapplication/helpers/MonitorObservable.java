package com.example.alumno.myapplication.helpers;

import com.example.alumno.myapplication.models.client;

import java.util.Observable;

public class MonitorObservable extends Observable {
    client wachedValue;
    public MonitorObservable(client o){
        this.wachedValue = o;}

        public void setWachedValue(client o){
            if (o != null && o.getOld_year() != this.wachedValue.getOld_year()){
                this.wachedValue = o;
            setChanged();
            notifyObservers();

        } else   {
            setChanged();

           notifyObservers(o);

        }
    }
}

