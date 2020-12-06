package com.test.car;

public class Cub {
    private int p;
    private int s;
     private int v;

    int a;
    //int b;    //для парал-да нужны 3
    //int c;

    public void perimetr(int a){
        this.p=a*16;  //для парал-да нужно (a+b+c)*4
    }

    public void size(int a, int b, int c){
        this.s=a*6; //для парал-да нужно (a*c)*2+(c*b)*4
    }

    public void space(int a){
        this.v=a*a*a;  //a^3   //для парал-да нужно a*b*c
    }
}
