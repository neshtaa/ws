package main.java;

import java.util.*;

public class Road {
    public ArrayList<ArrayList<? extends Vehicle>> carsInRoad = new ArrayList<>();


    public int getCountOfHumans() {
        int result = 0;
        for(ArrayList<? extends Vehicle> vehicle: carsInRoad) {
            result += vehicle.get(0).getNumberOfPassengers();
        }
        return result;
    }

    public void addCarToRoad(typeOfCar type) {
        if(type == typeOfCar.POLICE_CAR){
            ArrayList<PoliceCar> car = new ArrayList<PoliceCar>();
            car.add(new PoliceCar("Police","Interceptor",4));
            carsInRoad.add(car);
        }
        else if(type == typeOfCar.FIRE_ENGINE){
            ArrayList<FireEngine> car = new ArrayList<FireEngine>();
            car.add(new FireEngine("Ford","1833 DC",8));
            carsInRoad.add(car);
        }
        else if(type == typeOfCar.BUS){
            ArrayList<Bus> car = new ArrayList<Bus>();
            car.add(new Bus("MAN","A30 NL",46));
            carsInRoad.add(car);
        }
        else{
            ArrayList<Taxi> car = new ArrayList<Taxi>();
            car.add(new Taxi("Hyundai","Sonata",3));
            carsInRoad.add(car);
        }
    }

    public ArrayList<? super Human> addPassenger(Human human) {
        ArrayList<? super Human> p1 = new ArrayList<>();
        p1.add(human);
        return p1;
    }

    public static void main(String[] args) throws Exception {
        Road r1 = new Road();
        List<ArrayList<? super Human>> passengers = new ArrayList<>();
        passengers.add(r1.addPassenger(new Policeman("John", 34, "Corporal", 99)));
        passengers.add(r1.addPassenger(new Human("Carl", 20)));
        passengers.add(r1.addPassenger(new Firefighter("Tom", 27,"Sergeant", 12)));

        r1.addCarToRoad(typeOfCar.BUS);
        r1.addCarToRoad(typeOfCar.POLICE_CAR);
        r1.addCarToRoad(typeOfCar.TAXI);
        r1.addCarToRoad(typeOfCar.FIRE_ENGINE);
        try {
            r1.carsInRoad.get(1).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(0));
            r1.carsInRoad.get(0).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(1));
            r1.carsInRoad.get(3).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(2));
            //r1.carsInRoad.get(1).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(1));
            r1.carsInRoad.get(2).get(0).takeASeat((ArrayList<? extends Human>) passengers.get(0));
            r1.carsInRoad.get(0).get(0).toFreeSeat((ArrayList<? extends Human>) passengers.get(1));
        } catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(r1.getCountOfHumans());
    }
}
