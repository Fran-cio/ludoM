package com.company.strategy;

public class Wait implements Status {
    public Wait() {
    }

    public Status getStatus(){
        return this;
    }
}
