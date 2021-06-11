package com.company;

public class Dado {
    private int numero;

    public Dado(){
        numero=0;
    }

    public int tirarDado(){
        return (int)(Math.random()*6 + 1);
    }

}


