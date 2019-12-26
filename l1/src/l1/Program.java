package l1;
import java.util.Scanner;

public class Program {
  
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("размер массива string: ");
      int size = in.nextInt();
      String[] ar = new String[size]; 
      float temp = 0.0F;
      System.out.println("массив string:");
      try {
          for (int i = 0; i < ar.length; i++)
              temp += (ar[i] = in.next()).length();
      } finally {
          in.close();
      }
      float centerLength = temp / ar.length;
      System.out.println("Result:");
      int i;
      for (i = 0; i < ar.length; i++) {
          if (ar[i].length() < centerLength)
              System.out.println(ar[i]);
      
      }
    }
    }
  
      
      
      


