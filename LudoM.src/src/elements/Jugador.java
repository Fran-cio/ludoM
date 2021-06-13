package elements;

import strategy.jugador.*;

public class Jugador {
    protected Player player;
    protected boolean estado;
    public      Object       num= new Object();


    public Jugador(int id, Tablero tablero) {
        this.estado = false;
        if(id==1){
            setPlayer(new Player_1(tablero));
        }
        else if(id==2){
            setPlayer(new Player_2(tablero));
        }
        else if(id==3){
            setPlayer(new Player_3(tablero));
        }
        else if(id==4){
            setPlayer(new Player_4(tablero));
        }
        else {
            System.out.println("Numero de jugadores invalido");
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public synchronized void moverFicha(Dado dado,Tablero tablero) {
        int resultado = dado.tirarDado();
        System.out.println("Dado: "+resultado);
        boolean hecha = false;
        if(player.getFichas()[0].getStatus().jugadaposible(resultado)||
                player.getFichas()[1].getStatus().jugadaposible(resultado)||
                player.getFichas()[2].getStatus().jugadaposible(resultado)||
                player.getFichas()[3].getStatus().jugadaposible(resultado)){
            while (!hecha) {
                System.out.println("Elija la ficha:");
                try {
                    synchronized (tablero.partida.thread) {
                        tablero.partida.thread.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hecha = player.getFichas()[(int)num - 1].getStatus().mover(tablero, player.getFichas()[(int)num - 1], resultado);
            }
            if (resultado == 6 && hecha) {
                moverFicha(dado,tablero);
            }
        }
        //Aca deberia implementar una decision de que pieza se puede mover
    }
    public void setNum(int n){
        num=n;
    }

    public Player getPlayer() {
        return player;
    }
}

