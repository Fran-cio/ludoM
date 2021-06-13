import elements.Partida;
import vista.Ventana;

public class Main {

    public static void main(String[] args) {

        //new Tabla().setVisible(true);
        Partida partida= new Partida(4);
        Ventana ventana=new Ventana(partida);
    }
}

