package strategy.status;

import elements.Ficha;
import elements.Tablero;
import org.testng.internal.collections.Pair;

public class Wait implements Status {
    private String state;

    public Wait() {
        this.state="Wait";
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
        if(n==6){
            Pair aux= ficha.getCamino()[ficha.getPuntero()+1];
            Pair act=   ficha.getCamino()[ficha.getPuntero()];
            tab.RemoveFicha((int)act.first(),(int)act.second(),ficha);
            tab.Setficha((int)aux.first(),(int)aux.second(),ficha,1);
            System.out.println("Ficha: "+(ficha.getIdF()+1)+" salto a la casilla: "+ ficha.getCamino()[ficha.getPuntero()].first() +";"+ ficha.getCamino()[ficha.getPuntero()].second());
            return true;
        }
        System.out.println("Sigo esperando...");
        return false;
    }

    @Override
    public void comer() {

    }

    @Override
    public boolean jugadaposible(int n) {
        return n == 6;
    }
}
