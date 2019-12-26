package main.java;

public class Firefighter extends Human {
    private String rank;
    private int numberOfBrigade;

    public Firefighter(String _name, int _age, String _rank, int _numberOfBrigade) {
        super(_name, _age);
        setType(typeOfHuman.FIREFIGHTER);
        rank = _rank;
        numberOfBrigade = _numberOfBrigade;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public int getNumberOfBrigade() {
        return numberOfBrigade;
    }

    public void setNumberOfBrigade(int numberOfBrigade) {
        this.numberOfBrigade = numberOfBrigade;
    }
}
