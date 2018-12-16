import java.util.*;
import java.io.*;
import java.util.Scanner;

public class firstFactorial {

  public static int FirstFactorial(int num) {
      int total = 1;

      for (int x = 1; x<=num; x++) {
        //System.out.println(x);
        total = total*x;
      }

      return total;
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(FirstFactorial(s.nextInt()));
  }

}
