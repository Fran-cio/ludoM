package elements;

import strategy.status.*;

public class Tablero{
    protected Casilla[][] tablero;
    protected Partida     partida;
    protected Jugador     winner;

    public Tablero(Partida part) {
        partida=part;
        tablero= new Casilla[15][15];
        for(int i=0; i!=15 ;i++) {
            for (int j = 0; j != 15; j++) {
                tablero[i][j]= new Casilla();
                tablero[i][j].setStatus(new Moving());
            }
        }
        setWaits();
        setProtecteds();
        setRectaFinal();
        setWin();
        setOutOfBounds();
    }
    public Tablero() {
        tablero= new Casilla[15][15];
        for(int i=0; i!=15 ;i++) {
            for (int j = 0; j != 15; j++) {
                tablero[i][j]= new Casilla();
                tablero[i][j].setStatus(new Moving());
            }
        }
        setWaits();
        setProtecteds();
        setRectaFinal();
        setWin();
        setOutOfBounds();
    }
    public void siguienteJugada(){

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

    public Partida getPartida() {
        return partida;
    }

    public Casilla getCasilla(int x, int y){
        return tablero[x][y];
    }

    public void Setficha(int x, int y,Ficha ficha, int n){
        tablero[x][y].setFicha(ficha,this,n);
    }
    public void RemoveFicha(int x,int y, Ficha ficha){
        tablero[x][y].removeFicha(ficha);
    }

    public void terminar(String winner){
        System.out.println("And The Winner is Player "+winner+", Congrats, you win a coquita de vidrio");
        partida.terminar();
    }
}
