package com.test.car;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public abstract class MainActivity extends AppCompatActivity {

    car car=null;

    TextView txtTank;
    TextView txtWeight;
    TextView txtTakhometre;
    TextView txtWidth;
    TextView txtHeight;
    TextView txtVinCode;
    TextView txtMark;
    TextView txtIsEngine;

    int speed;
    float tankFull;
    float tank;
    short takhometre ;
    int weight ;
    int width ;
    int height ;
    long vinCode ;
    char mark;
    boolean isEngine = true;

    static String text = "";

    public static int A_PLUS_B(int a , int b){
        return a+b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Singleton singleton=Singleton.getInstance();
        singleton.count++;
        Singleton singleton2=Singleton.getInstance();
        System.out.println("Count = "+singleton2.count);

        Book book=Book.getInstance();
        book.someth++;
        Book book2=Book.getInstance();
        System.out.println("Someth = "+book2.someth);

        car.setHeight(1500);
        car.setWidth(5500);




        txtTank = findViewById(R.id.txtTank);
        txtWeight = findViewById(R.id.txtWeight);
        txtTakhometre = findViewById(R.id.txtTakhometre);
        txtWidth = findViewById(R.id.txtWidth);
        txtHeight = findViewById(R.id.txtHeight);
        txtVinCode = findViewById(R.id.txtVinCode);
        txtMark = findViewById(R.id.txtMark);
        txtIsEngine = findViewById(R.id.txtIsEngine);

        txtTank.setText("Tank=" + tank);
        txtWeight.setText("Weight=" + weight);
        txtTakhometre.setText("Takhometre=" + takhometre);
        txtWidth.setText("Width=" + width);
        txtHeight.setText("Height=" + height);
        txtVinCode.setText("VinCode=" + vinCode);
        txtMark.setText("Mark=" + mark);
        txtIsEngine.setText("IsEngine=" + isEngine);




        startEngine();
        accelerate(5);
        accelerate(10);
        accelerate(10);
        accelerate(10);
        accelerate(10);
        decelerate(30);
        decelerate(30);

        stopEngine();

        someMath();


    }

    void someMath(){
        car.startEngine();
        if(car.tank == 0)return;
        car.accelerate(5);
        car.accelerate(10);
        car.accelerate(10);
        car.accelerate(10);
        car.accelerate(10);
        car.accelerate(30);
        car.accelerate(30);
        car.stopEngine();

    }

    void startEngine() {
        if(tank>0 && speed==0){
            isEngine=true;
        }
        else if(isEngine){
            System.out.println("Car is already running");
        }
        System.out.println("Car is running");
      /*  int x1 = 0;
        isEngine = true;
        x1 = 1;
        System.out.println("Car is running");*/
    }

    void stopEngine() {
        if(!isEngine)return;
        isEngine = false;
        System.out.println("Car is stop");
    }
    void refueling(float quantity) {
        float i = tank;
        if (quantity >= (tankFull - tank)){
            System.out.println("излишек топлива в размере" + ((quantity + tank) - tankFull) + "литров");
            System.out.println("машина заправлена на " + (tankFull - i) + "литров");
            tank = tankFull;
        }else{
            tank += quantity;
            System.out.println("машина заправлена на " + (tank - i) + "литров");
        }
    }
     void accelerate(int velocity){
        if(!isEngine)return;
        if (tank<=0){
            speed=0;
            stopEngine();
            return;
        } else{
            tank--;
            speed+=velocity;
            System.out.println("Наша скорость теперь:" + speed);
        }
        if(tank<=5){System.out.println("Внимание критический уровень топлива");}
        if(tank==0){
            refueling(tankFull/2);
            System.out.println("Машина заправлена на пол бака");
        }
    }

    void decelerate(int velocity) {
        if(!isEngine)return;
        if (tank<=0){
            stopEngine();
            speed=0;
            return;
        }
        speed-=velocity;
        if (speed<=0){
            speed=0;
        }
        System.out.println("Наша скорость теперь="+speed);
    }


}

