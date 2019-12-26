import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class TravelCard{

    private int id;
    private Type type;
    private Calendar validity;
    private int numberOfTravels;

    TravelCard(int _id, Type _type, Calendar _validity, int _numberOfTravels){
        this.id = _id;
        this.type = _type;
        this.validity = _validity;
        this.numberOfTravels = _numberOfTravels;
    }

    public Type getType(){
        return type;
    }

    public Calendar getValidity() {
        return validity;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfTravels(){
        return numberOfTravels;
    }

    public void setNumberOfTravels(int numberOfTravels) {
        this.numberOfTravels = numberOfTravels;
    }

    boolean checkValidity(Calendar currentDate){
        if(currentDate.getTime().after(this.validity.getTime()))
            return false;
        else
            return true;
    }

    int takeOffTravel(){
        if(this.numberOfTravels == 0)
            return -1;
        else
            this.numberOfTravels--;
        return this.numberOfTravels;
    }
}