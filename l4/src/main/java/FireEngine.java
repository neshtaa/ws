package main.java;

import java.util.List;

public class FireEngine extends Car{
    FireEngine(String _brand, String _model, int _maxCapacity) {
        super(_brand, _model, _maxCapacity);
        setType(typeOfCar.FIRE_ENGINE);
    }

//    public void pickUpPassenger(List<? extends Human> passenger) throws Exception {
//        if(passenger.get(0).getType() == typeOfHuman.FIREFIGHTER)
//            takeASeat(passenger.get(0));
//        else
//            throw new Exception("Wrong type of human");
//    }
}
