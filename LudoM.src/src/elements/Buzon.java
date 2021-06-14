package elements;

public class Buzon {
    public  Casilla[][] casillas;
    public  int         valorDado;
    public  String      Jugada;
    public  String      infoExtra;
    public  String      siguienteJugador;

    public Buzon(Casilla[][] casillas, int valorDado,String siguienteJugador, String jugada, String infoExtra) {
        this.casillas = casillas;
        this.valorDado = valorDado;
        Jugada = jugada;
        this.infoExtra = infoExtra;
        this.siguienteJugador=siguienteJugador;
    }
}
