package strategy.status;

import elements.Ficha;
import elements.Tablero;
import org.testng.internal.collections.Pair;

public class Protected implements Status {
    private String state;

    public Protected() {
        this.state="Protected";
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
        Pair aux= ficha.getCamino()[ficha.getPuntero()+n];
        Pair act=   ficha.getCamino()[ficha.getPuntero()];
        tab.RemoveFicha((int)act.first(),(int)act.second(),ficha);
        tab.Setficha((int)aux.first(),(int)aux.second(),ficha,n);
        System.out.println("Ficha: "+(ficha.getIdF()+1)+" salto a la casilla: "+(int)ficha.getCamino()[ficha.getPuntero()].first()+";"+(int)ficha.getCamino()[ficha.getPuntero()].second());
        return true;
    }

    @Override
    public void comer() {

    }

    @Override
    public boolean jugadaposible(int n) {
        return true;
    }
}
