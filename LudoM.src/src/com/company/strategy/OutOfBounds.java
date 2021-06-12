package com.company.strategy;

public class OutOfBounds implements Status{
    @Override
    public Status getStatus() {
        return this;
    }
}
