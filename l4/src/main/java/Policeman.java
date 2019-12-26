package main.java;

public class Policeman extends Human{
    private String rank;
    private int numberOfDepartment;

    public Policeman(String _name, int _age, String _rank, int _numberOfDepartment) {
        super(_name, _age);
        setType(typeOfHuman.POLICEMAN);
        rank = _rank;
        numberOfDepartment = _numberOfDepartment;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getNumberOfDepartment() {
        return numberOfDepartment;
    }

    public void setNumberOfDepartment(int numberOfDepartment) {
        this.numberOfDepartment = numberOfDepartment;
    }
}
