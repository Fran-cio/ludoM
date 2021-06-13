package elements;

import observer.Observador;
import observer.Sujeto;

import java.util.Vector;



public class Partida implements Sujeto {
    protected final Dado          dado;
    protected Tablero             tablero;
    protected Jugador[]           arrJugadores;
    protected Vector<Ficha>       arrFichas;
    protected Vector<Observador>  arrObserver;
    protected int                 tiempoPart;
    protected boolean             terminada;
    protected int                 nextplayer;

    public Partida(int numeroJugadores){
        tablero=new Tablero(this);
        dado=   new Dado();
        terminada=false;

        if(numeroJugadores>1&&5>numeroJugadores){
            arrJugadores= new Jugador[numeroJugadores];
            for(int i=0; i!=numeroJugadores; i++){
               arrJugadores[i]=new Jugador(i+1,tablero);
            }
        }

        else{
            System.out.println("Inserte Numero de jugadores valido");
            terminar();
        }

    }

    public void iniciarPartida(){
        nextplayer=0;
        while(!terminada){
            if(nextplayer==arrJugadores.length){
                nextplayer=0;
            }
            System.out.println(arrJugadores[nextplayer].getPlayer().getANSI()+"jugador "+arrJugadores[nextplayer].getPlayer().getColor());
            arrJugadores[nextplayer].moverFicha(dado,tablero);
            System.out.println();
            nextplayer++;
        }
    }

    public void pausar(){

    }

    public void reanudar(){

    }

    public void terminar(){
        terminada=true;
        //System.exit(0);
    }

    @Override
    public void registrar(Observador obs) {

    }

    @Override
    public void desregistrar(Observador obs) {

    }

    @Override
    public void notificar() {

    }
}
