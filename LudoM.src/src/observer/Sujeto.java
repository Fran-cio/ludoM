package observer;

import elements.Casilla;

public interface Sujeto {
    public void registrar(Observador obs);
    public void desregistrar(Observador obs);
    public void mostrar(Casilla[][] casillas, int valorDado,String siguienteJugador, String jugada, String infoExtra);
}
