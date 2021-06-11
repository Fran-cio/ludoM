package com.company;

import com.company.strategy.Status;

public class Ficha {
    private Status status;
    private int     idF;
    private String  colorF;
    private int     posicionX;
    private int     posicionY;

    public Ficha(String color,int x,int y,int id){
        colorF=color;
        setPosicion(x,y);
        idF=id;
    }

    public int getIdF() {
        return idF;
    }

    public int getPosicionX(){
        return posicionX;
    }

    public int getPosicionY(){
        return posicionY;
    }

    public void setPosicion(int x,int y){
        posicionX=x;
        posicionY=y;
    }

    public void setStatus(Status newStatus){
        status=newStatus;
    }


}
