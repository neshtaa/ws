package main.java;

import java.util.List;

public class Bus extends Vehicle {
    Bus(String _brand, String _model, int _maxCapacity) {
        super(_brand, _model, _maxCapacity);
        setType(typeOfCar.BUS);
    }

//    public void pickUpPassenger(List<? extends Human> passenger) throws Exception {
//        takeASeat(passenger);
//    }
}
