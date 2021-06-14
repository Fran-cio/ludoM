package elements;

import strategy.status.Status;

import java.util.Vector;

public class Casilla {
    protected Status status;
    protected Vector<Ficha>  acumfichas;

    public Casilla() {
        acumfichas= new Vector<>();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setFicha(Ficha f,Tablero tablero,int n){
        f.setStatus(status);
        if(acumfichas.size()==0||acumfichas.isEmpty()) {
            f.setStatus(this.status);
            f.incPuntero(n);
            acumfichas.add(f);
        }
        else if(status.getState().equals("Protected")||status.getState().equals("Win")||status.getState().equals("Wait")) {
            f.incPuntero(n);
            f.setStatus(this.status);
            acumfichas.add(f);
            if(status.getState().equals("Win") && acumfichas.size()==4){
                tablero.terminar(acumfichas.firstElement().getColorF());
            }
        }
        else{
            if(acumfichas.firstElement().getColorF().equals(f.getColorF())){
                f.incPuntero(n);
                f.setStatus(this.status);
                acumfichas.add(f);
            }
            else{
                int aux=acumfichas.size();
                for(int i = 0; aux != i; i++){
                    tablero.Setficha((int)acumfichas.get(i).getCamino()[0].first(),(int)acumfichas.get(i).getCamino()[0].second(),acumfichas.get(i),0);
                    acumfichas.get(i).resetPuntero();
                    System.out.println( (acumfichas.get(i).getIdF()+1)+" color "+acumfichas.get(i).getColorF()+" ha sido comida");
                    removeFicha(acumfichas.get(i));
                }
                acumfichas.clear();
                f.incPuntero(n);
                acumfichas.add(f);
                f.setStatus(this.status);
            }
        }

    }
    public void removeFicha(Ficha f){
        acumfichas.remove(f);
    }

    public Vector<Ficha> getAcumfichas() {
        return acumfichas;
    }
}
