package elements;

import strategy.jugador.*;

public class Jugador {
    protected   Player  player;
    protected   boolean estado;
    public      Object  num= new Object();
    private     String  stat;



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
        stat="Mestas Cargando...";
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public synchronized void moverFicha(Dado dado,Tablero tablero) {
        int resultado = dado.tirarDado();

        stat= getStat(tablero);
        tablero.partida.mostrar(tablero.getTablero(), resultado,this.getPlayer().getColor(),stat,"");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            stat= getStat(tablero);
            //System.out.println(stat);
            tablero.partida.mostrar(tablero.getTablero(), resultado,this.getPlayer().getColor(),stat,"");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    public String getStat(Tablero tablero){
        String s="";
        s=s+"<html>Jugador: "+tablero.partida.arrJugadores[0].getPlayer().getColor()+"<p>"+
                "Ficha 1: "+tablero.partida.arrJugadores[0].player.getFichas()[0].status.getState()+
                "("+ tablero.partida.arrJugadores[0].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[0].getPuntero()].first() +","+
                tablero.partida.arrJugadores[0].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[0].getPuntero()].second() +")"+"<p>"+
                "Ficha 2: "+tablero.partida.arrJugadores[0].player.getFichas()[1].status.getState()+
                "("+ tablero.partida.arrJugadores[0].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[1].getPuntero()].first() +","+
                tablero.partida.arrJugadores[0].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[1].getPuntero()].second() +")"+"<p>"+
                "Ficha 3: "+tablero.partida.arrJugadores[0].player.getFichas()[2].status.getState()+
                "("+ tablero.partida.arrJugadores[0].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[1].getPuntero()].first() +","+
                tablero.partida.arrJugadores[0].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[1].getPuntero()].second() +")"+"<p>"+
                "Ficha 4: "+tablero.partida.arrJugadores[0].player.getFichas()[3].status.getState()+
                "("+ tablero.partida.arrJugadores[0].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[1].getPuntero()].first() +","+
                tablero.partida.arrJugadores[0].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[0].player.getFichas()[1].getPuntero()].second() +")"+"<p><p>"+

                "Jugador: "+tablero.partida.arrJugadores[1].getPlayer().getColor()+"<p>"+
                "Ficha 1: "+tablero.partida.arrJugadores[1].player.getFichas()[0].status.getState()+
                "("+ tablero.partida.arrJugadores[1].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[0].getPuntero()].first() +","+
                tablero.partida.arrJugadores[1].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[0].getPuntero()].second() +")"+"<p>"+
                "Ficha 2: "+tablero.partida.arrJugadores[1].player.getFichas()[1].status.getState()+
                "("+ tablero.partida.arrJugadores[1].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[1].getPuntero()].first() +","+
                tablero.partida.arrJugadores[1].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[1].getPuntero()].second() +")"+"<p>"+
                "Ficha 3: "+tablero.partida.arrJugadores[1].player.getFichas()[2].status.getState()+
                "("+ tablero.partida.arrJugadores[1].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[2].getPuntero()].first() +","+
                tablero.partida.arrJugadores[1].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[2].getPuntero()].second() +")"+"<p>"+
                "Ficha 4: "+tablero.partida.arrJugadores[1].player.getFichas()[3].status.getState()+
                "("+ tablero.partida.arrJugadores[1].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[3].getPuntero()].first() +","+
                tablero.partida.arrJugadores[1].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[1].player.getFichas()[3].getPuntero()].second() +")"+"<p><p>";
                if(tablero.partida.arrJugadores.length>2) {
                    s += "Jugador: " + tablero.partida.arrJugadores[2].getPlayer().getColor() + "<p>" +
                            "Ficha 1: " + tablero.partida.arrJugadores[2].player.getFichas()[0].status.getState() +
                            "(" + tablero.partida.arrJugadores[2].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[0].getPuntero()].first() + "," +
                            tablero.partida.arrJugadores[2].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[0].getPuntero()].second() + ")" + "<p>" +
                            "Ficha 2: " + tablero.partida.arrJugadores[2].player.getFichas()[1].status.getState() +
                            "(" + tablero.partida.arrJugadores[2].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[1].getPuntero()].first() + "," +
                            tablero.partida.arrJugadores[2].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[1].getPuntero()].second() + ")" + "<p>" +
                            "Ficha 3: " + tablero.partida.arrJugadores[2].player.getFichas()[2].status.getState() +
                            "(" + tablero.partida.arrJugadores[2].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[2].getPuntero()].first() + "," +
                            tablero.partida.arrJugadores[2].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[2].getPuntero()].second() + ")" + "<p>" +
                            "Ficha 4: " + tablero.partida.arrJugadores[2].player.getFichas()[3].status.getState() +
                            "(" + tablero.partida.arrJugadores[2].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[3].getPuntero()].first() + "," +
                            tablero.partida.arrJugadores[2].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[2].player.getFichas()[3].getPuntero()].second() + ")" + "<p><p>";
                    if (tablero.partida.arrJugadores.length > 3) {
                        s+="Jugador: " + tablero.partida.arrJugadores[3].getPlayer().getColor() + "<p>" +
                                "Ficha 1: " + tablero.partida.arrJugadores[3].player.getFichas()[0].status.getState() +
                                "(" + tablero.partida.arrJugadores[3].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[0].getPuntero()].first() + "," +
                                tablero.partida.arrJugadores[3].player.getFichas()[0].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[0].getPuntero()].second() + ")" + "<p>" +
                                "Ficha 2: " + tablero.partida.arrJugadores[3].player.getFichas()[1].status.getState() +
                                "(" + tablero.partida.arrJugadores[3].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[1].getPuntero()].first() + "," +
                                tablero.partida.arrJugadores[3].player.getFichas()[1].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[1].getPuntero()].second() + ")" + "<p>" +
                                "Ficha 3: " + tablero.partida.arrJugadores[3].player.getFichas()[2].status.getState() +
                                "(" + tablero.partida.arrJugadores[3].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[2].getPuntero()].first() + "," +
                                tablero.partida.arrJugadores[3].player.getFichas()[2].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[2].getPuntero()].second() + ")" + "<p>" +
                                "Ficha 4: " + tablero.partida.arrJugadores[3].player.getFichas()[3].status.getState() +
                                "(" + tablero.partida.arrJugadores[3].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[3].getPuntero()].first() + "," +
                                tablero.partida.arrJugadores[3].player.getFichas()[3].getCamino()[tablero.partida.arrJugadores[3].player.getFichas()[3].getPuntero()].second() + ")" + "<p>";
                    }
                }
                s+= "<html>";
        return s;
    }
}

