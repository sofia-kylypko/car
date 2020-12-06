package com.test.car;

public class Moto extends car{

    public static int count;

    public Moto(float tankFull, int weight, int height, int width, String mark) {
        super(2,tankFull, weight, height, width, mark);
    }

    public Moto(byte count, float tankFull, int weight, int height, int width, String mark) {

        super(count, tankFull, weight, height, width, mark);

        MainActivity.text="STATIC TEXT";
    }


}
