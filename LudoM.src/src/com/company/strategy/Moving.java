package com.company.strategy;

public class Moving implements Status {
    public Status getStatus(){
        return this;
    }
}
