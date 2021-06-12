package elements;
//maxi fuma afuera
import org.testng.internal.collections.Pair;
import strategy.status.Status;

public class Ficha {
    private Status  status;
    private int     idF;
    private String  colorF;
    private int     posicionX;
    private int     posicionY;
    private Pair    camino[];
    private int     puntero;

    public Ficha(String color,int x,int y,int id){
        colorF=color;
        setPosicion(x,y);
        idF=id;
        puntero=0;
    }

    public int getIdF() {
        return idF;
    }

    public int getPosicionX(){
        return posicionX;
    }

    public int getPosicionY(){
        return posicionY;
    }

    public void setPosicion(int x,int y){
        posicionX=x;
        posicionY=y;
    }

    public void setStatus(Status newStatus){
        status=newStatus;
    }

    public Pair[] getCamino() {
        return camino;
    }

    public void setCamino(Pair[] camino) {
        this.camino = camino;
    }

    public int getPuntero() {
        return puntero;
    }
    public void incPuntero() {
        puntero++;
    }
    public void resetPuntero() {
        puntero=0;
    }
}
