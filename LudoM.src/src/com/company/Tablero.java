package com.company;


import com.company.observer.Observador;
import com.company.observer.Sujeto;
import com.company.strategy.Protected;
import com.company.strategy.Wait;

public class Tablero implements Observador {
    private Casilla     tablero[][];
    private Sujeto      subject;
    private Controller  controller;

    @Override
    public void actualizar() {

    }

    public Tablero(Sujeto sub) {
        subject=sub;
        tablero= new Casilla[15][15];
        setWaits();



    }
    public void setWaits(){
        for(int i=0;i==15;i++) {
            if (i == 6) {
                i = 9;
            }
            for (int j = 0; j == 6; j++) {
                this.tablero[i][j].setStatus(new Wait());
            }
            for (int k = 9; k == 14; k++) {
                this.tablero[i][k].setStatus(new Wait());
            }
        }
    }
    public void setProtecteds(){
        this.tablero[8][2].setStatus(new Protected());
        this.tablero[6][1].setStatus(new Protected());
        this.tablero[6][12].setStatus(new Protected());
        this.tablero[8][13].setStatus(new Protected());

        this.tablero[1][8].setStatus(new Protected());
        this.tablero[2][6].setStatus(new Protected());
        this.tablero[12][8].setStatus(new Protected());
        this.tablero[13][6].setStatus(new Protected());




    }
}
