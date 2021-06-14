package elements;

import observer.Observador;
import observer.Sujeto;
import vista.control.Teclado;

import java.util.Vector;



public class Partida implements Sujeto,Runnable {
    protected final Dado          dado;
    protected Tablero             tablero;
    protected Jugador[]           arrJugadores;
    protected Vector<Ficha>       arrFichas;
    protected Vector<Observador>  arrObserver;
    protected int                 tiempoPart;
    protected boolean             terminada;
    protected int                 nextplayer;
    public final Thread              thread;
    public Teclado                  teclado;

    public Partida(int numeroJugadores, Teclado teclado){
        this.teclado=teclado;
        thread= new Thread(this,"Partida");
        tablero=new Tablero(this);
        dado=   new Dado();
        terminada=false;
        arrObserver= new Vector<>();

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
    public Partida(int numeroJugadores){
        Teclado teclado= new Teclado();
        thread= new Thread(this,"Partida");
        tablero=new Tablero(this);
        dado=   new Dado();
        terminada=false;
        arrObserver= new Vector<>();

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
        thread.start();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
    public void setNum(int n){
        arrJugadores[nextplayer].setNum(n);
    }

    public Jugador[] getArrJugadores() {
        return arrJugadores;
    }

    public int getNextplayer() {
        return nextplayer;
    }

    @Override
    public void registrar(Observador obs) {
        arrObserver.add(obs);
    }

    @Override
    public void desregistrar(Observador obs) {
        arrObserver.remove(obs);
    }

    @Override
    public void mostrar(Casilla[][] casillas, int valorDado,String siguienteJugador, String jugada, String infoExtra) {
        for(int i = 0 ; i < arrObserver.size() ; i++){
            Observador observer = (Observador) arrObserver.get(i);
            Buzon buzon= new Buzon(casillas,  valorDado,siguienteJugador, jugada, infoExtra);
            observer.mostrar(buzon);
        }
    }

    public Tablero getTablero() {
        return tablero;
    }
}
