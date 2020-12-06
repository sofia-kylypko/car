package com.test.car;

public class Book {
    private static Book instance;
    public int someth;

    public Book(){

    }

    public static Book getInstance(){
        if (instance==null){
            instance= new Book();
        }
        return instance;
    }
}
