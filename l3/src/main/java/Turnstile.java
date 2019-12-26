import java.io.*;
import java.util.*;
//import java.lang.*;
import java.util.concurrent.TimeUnit;

public class Turnstile{

    static public ArrayList<TravelCard> cards = new ArrayList<TravelCard>();
    private ArrayList<String[]> logs = new ArrayList<String[]>();
	private Scanner scan;

    Turnstile() throws IOException{
        FileReader fr = new FileReader("E:\\javav\\ws\\l3\\src\\main\\java\\Cards.txt");
        scan = new Scanner(fr);
        int m = 0;
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            m++;
        }
        scan.close();
        fr = new FileReader("E:\\javav\\ws\\l3\\src\\main\\java\\Cards.txt");
        scan = new Scanner(fr);
        for(int i = 0; i < m; i++){
            int id = scan.nextInt();
            int type = scan.nextInt();
            int day = scan.nextInt();
            int month = scan.nextInt();
            int year = scan.nextInt();
            int n = scan.nextInt();
            System.out.println(id + " " + type + " " + day + " " + month + " " + year + " " + n);
            Calendar c = new GregorianCalendar(year, month, day);
            if(type == 0)
                cards.add(new TravelCard(id, Type.common, c, n));
            else if(type == 1)
                cards.add(new TravelCard(id, Type.pupil, c, n));
            else
                cards.add(new TravelCard(id, Type.student, c, n));
        }
        fr.close();
    }

    static void addNewCard(int _type, int validity, int numberOfTravels) throws IOException{
        Type type;
        if(_type == 0)
            type = Type.common;
        else if(_type == 1)
            type = Type.pupil;
        else
            type= Type.student;
        GregorianCalendar gcalendar = new GregorianCalendar();
        if(validity == 10)
            gcalendar.roll(Calendar.DATE, +10);
        else
            gcalendar.roll(Calendar.MONTH, +1);
        cards.add(new TravelCard(cards.size(), type, gcalendar, numberOfTravels));
        FileWriter fw = new FileWriter("E:\\javav\\ws\\l3\\src\\main\\java\\Cards.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        int t;
        if(cards.get(cards.size() - 1).getType() == Type.common)
            t = 0;
        else if(cards.get(cards.size() - 1).getType() == Type.pupil)
            t = 1;
        else
            t = 2;
        out.println(cards.get(cards.size() - 1).getId() + " " + t + " " + cards.get(cards.size() - 1).getValidity().get(Calendar.DAY_OF_MONTH) + " " + cards.get(cards.size() - 1).getValidity().get(Calendar.MONTH) + " " + cards.get(cards.size() - 1).getValidity().get(Calendar.YEAR) + " " + cards.get(cards.size() - 1).getNumberOfTravels() + " ");
        out.close();
    }

    public static void topOnCard(int id, int numberOfTravels){
        if(cards.get(id).getNumberOfTravels() != -100 || cards.get(id).getType() == Type.common)
            cards.get(id).setNumberOfTravels(cards.get(id).getNumberOfTravels() + numberOfTravels);
    }

    public static int transfer(int id){
        try {
            if(cards.get(id).getNumberOfTravels() == -100)
                if(cards.get(id).checkValidity(new GregorianCalendar()))
                    return 1;
                else
                    return -1;
            else
                return cards.get(id).takeOffTravel();
        }catch (Exception ex){
            return -2;
        }
    }

    void makeLogs(int card, int reaction) throws IOException{
        FileWriter fw = new FileWriter("E:\\javav\\ws\\l3\\src\\main\\java\\Logs.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        if(reaction == -2)
            out.print("Reading error! " + " \n");
        else if(reaction == -1)
            out.print(cards.get(card).getId() + " " + cards.get(card).getType() + " " + "Out of travels " + " \n");
        else
            out.print(cards.get(card).getId() + " " + cards.get(card).getType() + " " + reaction + " travels left " + " \n");
        out.close();
    }

    void getLogs(int mode) throws IOException{
        logs.clear();
        FileReader fr = new FileReader("E:\\javav\\ws\\l3\\src\\main\\java\\Logs.txt");
        Scanner scan = new Scanner(fr);
        int n = 0;
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            n++;
        }
        scan.close();
        fr = new FileReader("Logs.txt");
        scan = new Scanner(fr);
        for(int i = 0; i < n - 1; i++){
            String str[] = new String[3];
            str[0] = scan.next();
            str[1] = scan.next();
            str[2] = scan.nextLine();
            logs.add(str);
        }
        scan.close();
        if(mode == 0)
            for(String[] str: logs){
                System.out.println(str[0] + " " + str[1] + " " + str[2]);
            }
        else if (mode == 1){
            for(String[] str: logs){
                if(str[1].equals("common"))
                    System.out.println(str[0] + " " + str[1] + " " + str[2]);
            }
            System.out.println();
            for(String[] str: logs){
                if(str[1].equals("pupil"))
                    System.out.println(str[0] + " " + str[1] + " " + str[2]);
            }
            System.out.println();
            for(String[] str: logs){
                if(str[1].equals("student"))
                    System.out.println(str[0] + " " + str[1] + " " + str[2]);
            }
        }
    }

    static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n");

    }

    public static void main(String args[]) throws IOException{
        Turnstile t1 = new Turnstile();
        Scanner scan = new Scanner(System.in);
        while(true){
            clearScreen();
            System.out.print("Enter card->");
            int card = scan.nextInt();
            if(card == -11){
                clearScreen();
                System.out.print("What kind of card you want to create?(1 - validity card, 2 - card limited on number of travels, 3 - accumulative card, 4 - top on card)->");
                int mode = scan.nextInt();
                switch (mode){
                    case 1 : System.out.print("Enter type(0 - common, 1 - pupil, 2 - student)->"); int type = scan.nextInt(); System.out.print("1 - on 10 days, 2 - on month->"); int v = scan.nextInt(); if(v == 1) t1.addNewCard(type, 10, -100); else t1.addNewCard(type, 31, -100); break;
                    case 2 : System.out.print("Enter type(0 - common, 1 - pupil, 2 - student)->"); type = scan.nextInt(); System.out.print("1 - on 5 travels, 2 - on 10 travels->"); v = scan.nextInt(); if(v == 1) t1.addNewCard(type, 0, 5); else t1.addNewCard(type, 0, 10); break;
                    case 3 : System.out.print("Enter number of travles you pay->"); int n = scan.nextInt(); addNewCard(0, 0, n); break;
                    case 4 : System.out.print("Enter card->"); card = scan.nextInt(); System.out.print("Enter number of travels you pay->"); t1.topOnCard(card, scan.nextInt()); break;
                }
            }else if(card == -13){
                break;
            }else if(card == -12){
                System.out.print("0 - output logs in normal mode, 1 - output logs in sorted mode->");
                int a = scan.nextInt();
                t1.getLogs(a);
            }else{
                int m = t1.transfer(card);
                if(m == -2) {
                    System.out.print("Reading error!");
                }
                else if(m == -1) {
                    System.out.print("Out of travels!");
                }
                else{
                    System.out.print(m + " travels left");
                }
                t1.makeLogs(card, m);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        FileWriter fw = new FileWriter("Cards.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        for (TravelCard t: cards){
            if(t.getType() == Type.common)
                out.println(t.getId() + " " + 0 + " " + t.getValidity().get(Calendar.DAY_OF_MONTH) + " " + t.getValidity().get(Calendar.MONTH) + " " + t.getValidity().get(Calendar.YEAR) + " " + t.getNumberOfTravels() + " ");
            else if(t.getType() == Type.pupil)
                out.println(t.getId() + " " + 1 + " " + t.getValidity().get(Calendar.DAY_OF_MONTH) + " " + t.getValidity().get(Calendar.MONTH) + " " + t.getValidity().get(Calendar.YEAR) + " " + t.getNumberOfTravels() + " ");
            else
                out.println(t.getId() + " " + 2 + " " + t.getValidity().get(Calendar.DAY_OF_MONTH) + " " + t.getValidity().get(Calendar.MONTH) + " " + t.getValidity().get(Calendar.YEAR) + " " + t.getNumberOfTravels() + " ");
        }
        out.close();
    }

}