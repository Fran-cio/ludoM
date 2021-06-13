package elements;

import org.testng.internal.collections.Pair;
import strategy.status.Status;

public class Ficha {
    private Status          status;
    private final int       idF;
    private final String    colorF;
    private Pair[]          camino;
    private int             puntero;

    public Ficha(String color,int id){
        colorF=color;
        idF=id;
        puntero=0;
    }

    public int getIdF() {
        return idF;
    }


    public Pair[] getCamino() {
        return camino;
    }

    public int getPuntero() {
        return puntero;
    }

    public Status getStatus() {
        return status;
    }

    public String getColorF() {
        return colorF;
    }

    public void setStatus(Status newStatus){
        status=newStatus;
    }
    public void setCamino(Pair[] camino) {
        this.camino = camino;
    }

    public void incPuntero(int n) {
        puntero=puntero+n;
    }

    public void resetPuntero() {
        puntero=0;
    }
}
