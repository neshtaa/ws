package main.java;

import java.util.List;

public class Taxi extends Car {
    Taxi(String _brand, String _model, int _maxCapacity) {
        super(_brand, _model, _maxCapacity);
        setType(typeOfCar.TAXI);
    }

//    public void pickUpPassenger(List<? extends Human> passenger) throws Exception {
//        takeASeat(passenger);
//    }
}
