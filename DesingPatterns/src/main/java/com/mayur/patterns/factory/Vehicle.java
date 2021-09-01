package com.mayur.patterns.factory;

public abstract class Vehicle {

    public abstract int getNumberOFTyre();
    public abstract int getFuelType();

    @Override
    public String toString() {
        return "Vehicle{ Tyres :"+ getNumberOFTyre() +" & Fuel :"+getFuelType()+" }";
    }
}
