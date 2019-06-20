package com.example.alumno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alumno.myapplication.helpers.Callback;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.client;

import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    Button btnEdad;
    MonitorObservable monitorObservable;
    ObserverBind observerBind;
    client clienobject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienobject = new client();
        clienobject.setOld_year(19);

        monitorObservable = new MonitorObservable(clienobject);
        observerBind=new ObserverBind();
        observerBind.setCallback(new Callback() {
            @Override
            public void doThis(Observable o, Object x){
//todo lo que yo quiera
                Log.v("Alvarito", "xxx");
                Toast.makeText(MainActivity.this,clienobject.getOld_year()+"",Toast.LENGTH_SHORT).show();
            }
        });
        monitorObservable.addObserver(observerBind);
        btnEdad = (Button)findViewById(R.id.btnedad);
        btnEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clienobject.setOld_year(clienobject.getOld_year()+1);
                monitorObservable.setWachedValue(clienobject);
            }
        }
        );

    }
}
