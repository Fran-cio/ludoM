package com.company;

public class Ficha {
    private Status  status;
    private int     idF;
    private String  colorF;
    private int     posicionX;
    private int     posicionY;

    public Ficha(){

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

    public void setPosicionX(){

    }

    public void setPosicionY(){

    }

    public void setStatus(Status newStatus){
        status=newStatus;
    }


}
