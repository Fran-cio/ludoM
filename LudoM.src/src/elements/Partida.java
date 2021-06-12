package elements;

import observer.Observador;
import observer.Sujeto;
import strategy.jugador.Jugador;

import java.util.Vector;

public class Partida implements Sujeto {
    private Dado                dado;
    private Tablero             tablero;
    private Vector<Jugador>     arrJugadores;
    private Vector<Ficha>       arrFichas;
    private Vector<Observador>  arrObserver;
    private int                 tiempoPart;


    public Partida(){

    }

    public void iniciarPartida(){

    }

    public void pausar(){

    }

    public void reanudar(){

    }

    public void terminar(){

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
