package main.java;

import java.util.List;

public class PoliceCar extends Car{
    PoliceCar(String _brand, String _model, int _maxCapacity) {
        super(_brand, _model, _maxCapacity);
        setType(typeOfCar.POLICE_CAR);
    }

//    public void pickUpPassenger(List<? extends Human> passenger) throws Exception {
//        if(passenger.get(0).getType() == typeOfHuman.POLICEMAN)
//            takeASeat(passenger);
//        else
//            throw new Exception("Wrong type of human");
//    }
}
