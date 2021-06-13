package strategy.status;

import elements.Ficha;
import elements.Tablero;

public class OutOfBounds implements Status{
    private String state;

    public OutOfBounds() {
        this.state = "OutOfBounds";
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
        System.out.println("No deberias estar aca U_U");
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
