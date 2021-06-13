package strategy.jugador;

import elements.Ficha;

public interface Player {
    void genFichas();
    Ficha[] getFichas();
    int getIdJ();
    String getColor();
    String  getANSI();
}
