package elements;

import strategy.jugador.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jugador {
    private Player player;
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

    public void moverFicha(Dado dado,Tablero tablero) {
        int resultado = dado.tirarDado();
        System.out.println("Dado: "+resultado);
        boolean hecha = false;
        if(player.getFichas()[0].getStatus().jugadaposible(resultado)||
                player.getFichas()[1].getStatus().jugadaposible(resultado)||
                player.getFichas()[2].getStatus().jugadaposible(resultado)||
                player.getFichas()[3].getStatus().jugadaposible(resultado)) {
            while (!hecha) {
                System.out.println("Elija la ficha:");
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader flujoE = new BufferedReader(isr);
                try {
                    String sdato = flujoE.readLine();
                        int num = Integer.parseInt(sdato);
                        if (num > 0 && num <= 4) {
                            hecha = player.getFichas()[num - 1].getStatus().mover(tablero, player.getFichas()[num - 1], resultado);
                        } else {
                            System.out.println("Inserte numero entre 1 y 4");
                        }
                }
                catch(IOException cc){}
                if(resultado==6 && hecha){
                    moverFicha(dado,tablero);
                }
            }
        }

        //Aca deberia implementar una decision de que pieza se puede mover
    }

    public Player getPlayer() {
        return player;
    }
}

