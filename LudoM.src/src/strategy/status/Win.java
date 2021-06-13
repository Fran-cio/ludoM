package strategy.status;

import elements.Ficha;
import elements.Tablero;

public class Win implements Status {
    private String state;

    public Win() {
        this.state = "Win";
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getResto() {
        return 0;
    }

    @Override
    public boolean mover(Tablero tab, Ficha ficha, int n) {
        System.out.println("Ya ganaste campeon");
        return false;
    }

    @Override
    public void comer() {

    }

    @Override
    public boolean jugadaposible(int n) {
        return false;
    }
}
