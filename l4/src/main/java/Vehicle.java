package main.java;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Vehicle {
    public static final AtomicInteger count =  new AtomicInteger(0);
    private int number;
    private typeOfCar type;
    private String brand;
    private String model;
    private int maxCapacity;
    private List<ArrayList<? extends Human>> passengers = new ArrayList<>();

    Vehicle(String _brand, String _model, int _maxCapacity) {
        number = count.incrementAndGet();
        brand = _brand;
        model = _model;
        maxCapacity = _maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfPassengers() {
        return passengers.size();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public typeOfCar getType() {
        return type;
    }

    protected void setType(typeOfCar type) {
        this.type = type;
    }

    public void takeASeat(ArrayList<? extends Human> passenger) throws Exception {
        if(passenger.get(0).getType() == typeOfHuman.POLICEMAN && type == typeOfCar.POLICE_CAR)
            if(maxCapacity > passengers.size()) {
                ArrayList<? extends Human> p1 = new ArrayList<>();
                passengers.add(passenger);
            }
            else
                throw new Exception("All seats taken");
        else if(passenger.get(0).getType() == typeOfHuman.FIREFIGHTER && type == typeOfCar.FIRE_ENGINE)
            if(maxCapacity > passengers.size()) {
                passengers.add(passenger);
            }
            else
                throw new Exception("All seats taken");

        else if(type == typeOfCar.TAXI || type == typeOfCar.BUS)
            if(maxCapacity > passengers.size()) {
                passengers.add(passenger);
            }
            else
                throw new Exception("All seats taken");
         else
            throw new Exception("Wrong type of human");

    }

    public void toFreeSeat(List<? extends Human> passenger) throws Exception {
        if (!passengers.remove(passenger))
            throw new Exception("This passenger absent in this vehicle");
    }
}
