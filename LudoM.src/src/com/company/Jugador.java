package com.company;

import java.util.Vector;

public class Jugador {
    private boolean         estado;
    private String          nombre;
    private Vector<Ficha>   arrFicha;
    private int             idJ;

    public void moverFicha(Dado dado){
        int resutado= dado.tirarDado();

        //Aca deberia implementar una decision de que pieza se puede mover
    }
}
