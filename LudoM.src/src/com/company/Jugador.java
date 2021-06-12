package com.company;

public class Jugador {
    private boolean estado;
    private Ficha   arrFicha[];
    private int     idJ;

    public Jugador(int id,Tablero tablero) {
        this.estado = false;
        idJ=id;
        arrFicha= new Ficha[4];
        if(idJ==1){
            for(int i=0; i!=4 ;i++) {
                arrFicha[i]= new Ficha("Amarillo",5,1,i);
                tablero.Setficha(5,1,arrFicha[i]);
            }
        }
        else if(idJ==2){
            for(int i=0; i!=4 ;i++) {
                arrFicha[i]= new Ficha("Verde",5,1,i);
                tablero.Setficha(5,1,arrFicha[i]);
            }
        }
        else if(idJ==3){
            for(int i=0; i!=4 ;i++) {
                arrFicha[i]= new Ficha("Rojo",5,1,i);
                tablero.Setficha(5,1,arrFicha[i]);
            }
        }
        else if(idJ==4){
            for(int i=0; i!=4 ;i++) {
                arrFicha[i]= new Ficha("Azul",5,1,i);
                tablero.Setficha(5,1,arrFicha[i]);
            }
        }
    }

    public void moverFicha(Dado dado){
        int resutado= dado.tirarDado();
        //Aca deberia implementar una decision de que pieza se puede mover
    }
}
