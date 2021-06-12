package com.company.strategy;

public class RectaFinal implements Status{
    private int Resto;

    public RectaFinal(int resto) {
        Resto = resto;
    }

    @Override
    public Status getStatus() {
        return this;
    }
}
