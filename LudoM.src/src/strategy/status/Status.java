package strategy.status;

import elements.Ficha;
import elements.Tablero;

public interface Status {
    String getState();
    int    getResto();
    default Status getStatus(){
        return this;
    }
    boolean    mover(Tablero tab,Ficha ficha, int n);
    void    comer();
    boolean jugadaposible(int n);
}
