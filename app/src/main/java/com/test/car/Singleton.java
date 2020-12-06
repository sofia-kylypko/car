package com.test.car;

public class Singleton {
    private static Singleton instance;
    public int count;

    public Singleton(){

    }

    public static Singleton getInstance(){
        if (instance==null){
            instance= new Singleton();
        }
        return instance;
    }
}
