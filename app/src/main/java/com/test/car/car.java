package com.test.car;

public class car {
    private int speed = 0;
    private float tankFull;
    public float tank = 6;
    private short takhometre;
    private int weight;                  //поля
    private int width;
    private int height;
    private long vinCode;
    private String mark;
    private boolean isEngine;
    private float temperature = 20.0f;
    private boolean belt = false;
    private float oxegenWet = 30.0f;
    private float pressure = 4.3f;
    private int count;

    public car(int count, float tankFull, int weight, int height, int width, String mark) {
    }



    //public car(){ //дефолтный конструктор

    //}

    public void car(int count, float tankFull, int weight, int height, int width, String mark) { // перегрузка метода
        this.tankFull = tankFull;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.mark = mark;
        this.count = count;
        return;
    }

    public void init(float tankFull,  int weight, int height, int width, String mark){ // перегрузка метода
        this.tankFull=tankFull;
        this.weight=weight;
        this.height=height;
        this.width=width;
        this.mark=mark;
    }

    public void init(int х,  int q, int w , int e, String r){ // перегрузка метода
        this.tankFull=tankFull;
        this.weight=weight;
        this.height=height;
        this.width=width;
        this.mark=mark;
    }

    public int setWeight(){
        return weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float gatTank(){
            return tank;
    }

    void startEngine(){
        if(tank>0 && speed==0){
            isEngine=true;
        }
        else if(isEngine){
            System.out.println("Car is already running");
        }
        System.out.println("Car is running");
        int x1 = 0;
        isEngine = true;
        x1 = 1;
        System.out.println("Car is running");
    }/*


    private boolean isTemperatureNormal(){
        return temperature>10 && temperature<90;
    }

    private boolean isBeltLock(){
        return belt=true;
    }

    private boolean isOxygenWet(){
        return oxegenWet>20 && oxegenWet<70;
    }

    private boolean isPressureNormal(){
        return pressure<6 && pressure>2;
    }
*/
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
        tank--;
        speed+=velocity;
        temperature++;
        belt=true;

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


    private void refueling(float quantity) {
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


    public void stopEngine() {
        if(!isEngine)return;
        isEngine = false;
        System.out.println("Car is stop");
    }

    public void setWidth(int i) {
        this.width=width;
    }
}


