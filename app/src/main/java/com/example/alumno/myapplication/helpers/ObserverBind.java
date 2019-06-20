package com.example.alumno.myapplication.helpers;

import android.util.Log;
import java.util.Observer;
import java.util.Observable;

public class ObserverBind  implements Observer {
    private Callback callback;

    @Override
    public void update(Observable o, Object arg){
        Log.v("Alvarito", "Update <<<<");
        if (this.callback!= null){
            this.callback.doThis(o, arg);
        }
    }
    public void setCallback(Callback callback){
        if (callback == null) {
            return;
        }
        this.callback = callback;
    }
}
