package strategy.jugador;

import elements.Dado;
import elements.Tablero;

public class Jugador {
    private Player  player;
    private boolean estado;


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

    public void moverFicha(Dado dado){
        int resutado= dado.tirarDado();
        //Aca deberia implementar una decision de que pieza se puede mover
    }
}
