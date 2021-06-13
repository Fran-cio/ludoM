package strategy.status;

import elements.Ficha;
import elements.Tablero;
import org.testng.internal.collections.Pair;

public class RectaFinal implements Status{
    private int Resto;
    private String state;

    public RectaFinal(int resto) {
        state="RectaFinal";
        Resto = resto;
    }

    public int getResto() {
        return Resto;
    }

    @Override
    public boolean mover(Tablero tab, Ficha ficha, int n) {
        if(n<=Resto){
            Pair aux= ficha.getCamino()[ficha.getPuntero()+n];
            Pair act=   ficha.getCamino()[ficha.getPuntero()];
            tab.RemoveFicha((int)act.first(),(int)act.second(),ficha);
            tab.Setficha((int)aux.first(),(int)aux.second(),ficha,n);
            System.out.println("Ficha: "+(ficha.getIdF()+1)+" salto a la casilla: "+(int)ficha.getCamino()[ficha.getPuntero()].first()+";"+(int)ficha.getCamino()[ficha.getPuntero()].second());
            if(ficha.getPuntero()==57){
                System.out.println("Ficha: "+(ficha.getIdF()+1)+" ha ganado");
            }
            return true;
        }
        System.out.println("No puedo porque me faltan "+Resto+" para llegar al final");
        return false;
    }

    @Override
    public void comer() {

    }

    @Override
    public boolean jugadaposible(int n) {
        if(n<=Resto){
            return true;
        }
        return false;
    }

    public void setResto(int resto) {
        Resto = resto;
    }

    @Override
    public String getState() {
        return state;
    }
}
