package com.company.strategy;

public class Protected implements Status {
    public Protected() {
    }

    public Status getStatus(){
        return this;
    }
}
