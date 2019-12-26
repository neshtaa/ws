import java.util.Scanner;
import com.google.gson.*;

public class Program {
  
    public static void main(String[] args) {
      
      Scanner in = new Scanner(System.in);
      Gson gson = new Gson();
      
        Person p1 = new Person("asd", "asdasd", "15.45.5185");
        p1.print();
                
        String json1 = gson.toJson(p1);
        System.out.println(json1);
        
        Person p2 = gson.fromJson(json1, Person.class);
        p2.print();
        if (p1.equals(p2)) System.out.println("true");
        else System.out.println("false");
        
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        
        in.close();
    }
}