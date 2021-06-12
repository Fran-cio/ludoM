package com.company;

import com.company.strategy.Status;

public class Casilla {
    private Status status;
    private Ficha  ficha;

    public Casilla() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setFicha(Ficha f){
        f.setStatus(status);
        ficha=f;
    }
}
