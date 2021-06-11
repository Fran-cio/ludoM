package com.company.observer;

public interface Sujeto {
    public void registrar(Observador obs);
    public void desregistrar(Observador obs);
    public void notificar();
}
