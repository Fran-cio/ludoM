import elements.Partida;
import menu.Menu;
import vista.Ventana;
import vista.control.Teclado;

public class Main {

    public static void main(String[] args) {
        Menu menu= new Menu();
        int numJugadores= menu.getJug();

        Teclado teclado= new Teclado();
        Partida partida= new Partida(numJugadores ,teclado);
        Ventana ventana=new Ventana(partida,teclado);
        partida.iniciarPartida();
    }
}

