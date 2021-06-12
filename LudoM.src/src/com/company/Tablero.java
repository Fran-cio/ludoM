package com.company;


import com.company.strategy.*;

public class Tablero{
    protected Casilla tablero[][];

    public Tablero() {
        tablero= new Casilla[15][15];
        for(int i=0; i!=15 ;i++) {
            for (int j = 0; j != 15; j++) {
                tablero[i][j]= new Casilla();
            }
        }
        setWaits();
        setProtecteds();
        setRectaFinal();
        setWin();
        setOutOfBounds();
    }

    public void setWaits(){
        for(int i=0; i!=15 ;i++) {
            if (i == 6) {
                i = 9;
            }
            for (int j = 0; j != 6; j++) {
                this.tablero[i][j].setStatus(new Wait());
            }
            for (int k = 9; k != 14; k++) {
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

    public void setRectaFinal(){
        for (int i = 1; i != 14; i++) {
            if (i == 6) {
                i = 9;
            }
            this.tablero[i][7].setStatus(new RectaFinal(Math.abs(7-i)-1));
            this.tablero[7][i].setStatus(new RectaFinal(Math.abs(7-i)-1));
        }
    }

    public void setWin(){
        this.tablero[8][7].setStatus(new Win());
        this.tablero[6][7].setStatus(new Win());
        this.tablero[7][6].setStatus(new Win());
        this.tablero[7][8].setStatus(new Win());
    }

    public void setOutOfBounds(){
        this.tablero[8][8].setStatus(new OutOfBounds());
        this.tablero[8][6].setStatus(new OutOfBounds());
        this.tablero[6][6].setStatus(new OutOfBounds());
        this.tablero[6][8].setStatus(new OutOfBounds());
    }

    public Casilla[][] getTablero() {
        return tablero;
    }
    public void Setficha(int x, int y, Ficha ficha){
        tablero[x][y].setFicha(ficha);
    }
}
