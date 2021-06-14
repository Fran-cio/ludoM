import elements.Partida;
import vista.Ventana;
import vista.control.Teclado;

public class Main {

    public static void main(String[] args) {
        //MainMenu main= new MainMenu();
        //new Tabla().setVisible(true);
        Teclado teclado= new Teclado();
        Partida partida= new Partida(2,teclado);
        Ventana ventana=new Ventana(partida,teclado);
        partida.iniciarPartida();
    }
}

