package test.java;

import main.java.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.platform.commons.*;
import static org.junit.Assert.*;

public class RoadTest {

    @Test
    public void getCountOfHumans() {
        Road road = new Road();
        List<ArrayList<? super Human>> passengers = new ArrayList<>();
        passengers.add(road.addPassenger(new Policeman("John", 34, "Corporal", 99)));
        passengers.add(road.addPassenger(new Human("Carl", 20)));
        passengers.add(road.addPassenger(new Firefighter("Tom", 27,"Sergeant", 12)));
        road.addCarToRoad(typeOfCar.POLICE_CAR);
        road.addCarToRoad(typeOfCar.TAXI);
        road.addCarToRoad(typeOfCar.FIRE_ENGINE);
        int expected1 = 3,
                expected2 = 2,
                expected3 = 1;
        try{
            road.carsInRoad.get(0).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(0));
            road.carsInRoad.get(1).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(1));
            road.carsInRoad.get(2).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(2));
        } catch (Exception e){
            //Never happens
        }
        Assert.assertEquals(expected1, road.getCountOfHumans());
        try {
            road.carsInRoad.get(0).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(0));
            road.carsInRoad.get(1).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(1));
            road.carsInRoad.get(2).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(2));
        } catch (Exception e) {
            //Never happens
        }
        try{
            road.carsInRoad.get(1).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(0));
            road.carsInRoad.get(2).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(2));
            road.carsInRoad.get(0).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(1));
        } catch (Exception e){
            //It happens, but shouldn't react
        }
        Assert.assertEquals(expected2, road.getCountOfHumans());
        try {
            road.carsInRoad.get(1).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(0));
            //road.carsInRoad.get(1).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(1));
            road.carsInRoad.get(2).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(2));
        } catch (Exception e) {
            //Never happens
        }
        try{
            road.carsInRoad.get(1).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(2));
            road.carsInRoad.get(2).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(0));
            road.carsInRoad.get(0).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(1));
        } catch (Exception e){
            //It happens, but shouldn't react
        }
        Assert.assertEquals(expected3, road.getCountOfHumans());
    }

    @Test
    public void addCarToRoad() {
        Road road = new Road();
        road.addCarToRoad(typeOfCar.POLICE_CAR);
        road.addCarToRoad(typeOfCar.TAXI);
        road.addCarToRoad(typeOfCar.FIRE_ENGINE);
        Assert.assertEquals(typeOfCar.POLICE_CAR, road.carsInRoad.get(0).get(0).getType());
        Assert.assertEquals(typeOfCar.TAXI, road.carsInRoad.get(1).get(0).getType());
        Assert.assertEquals(typeOfCar.FIRE_ENGINE, road.carsInRoad.get(2).get(0).getType());
    }
}