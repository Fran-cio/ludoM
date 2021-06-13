package elements;

import observer.Observador;
import observer.Sujeto;

import java.util.Vector;



public class Partida implements Sujeto {
    private final Dado          dado;
    private Tablero             tablero;
    private Jugador[]           arrJugadores;
    private Vector<Ficha>       arrFichas;
    private Vector<Observador>  arrObserver;
    private int                 tiempoPart;
    private boolean             terminada;
    private int                 nextplayer;



    public static final String ANSI_BLUE = "\u001B[34m";


    public Partida(int numeroJugadores){
        tablero=new Tablero();
        dado=   new Dado();
        arrJugadores= new Jugador[numeroJugadores];

        if(numeroJugadores>1||4<numeroJugadores){
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
        terminada=false;
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
        System.exit(0);
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
