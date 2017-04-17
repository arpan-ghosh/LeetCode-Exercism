import java.util.Scanner;

/** 7A */
public class HW7A4 {

   /** Averaging numbers in segments.
    *  @param previous value to the left
    *  @param next value to the right
    *  @return average of the numbers
    */
   public static double sumAll(double previous, double next) {
      final double numCount = 2.0;
      double sumofAll = 0.0;
      
      sumofAll = previous + next;
      sumofAll = sumofAll / numCount;
      
      return sumofAll;
   }

   /** Return boolean true if within epsilon.
    *  @param first previous array needing checking
    *  @param second averaged array needing checking
    *  @param epsilon the double we must be within range
    *  @return if within epsilon return true, else false 
    */
   public static boolean equality
      (double[] first, double[] second, double epsilon) {
      
      for (int g = 0; g < first.length;) {
      
         if (first[g] - second[g] == 0.0) {
            g++;
         }
         else if (first[g] - second[g] < -1 * epsilon) {
            g++;
         }
         else if (first[g] - second[g] > epsilon) {
            g++;
         }
         else {
            return false;
         }
         
      }
      return true;
   } 
      
   /** Main program to iterate through and compute averages.
    *  @param args not used
    */
   public static void main(String[] args) {
   
      final double epsilon = 0.001;
      double coolTemp = 0;
      double hotTemp = 0;
      int segments = 0;
   
      Scanner keyboard = new Scanner(System.in);
     
      System.out.println("enter cool temp, hot temp and # of segments:");
      
      coolTemp = keyboard.nextDouble();
      hotTemp = keyboard.nextDouble();
      segments = keyboard.nextInt();
      
      double[] oldTemps = new double[segments];
      double[] newTemps = new double[segments];
      
      oldTemps[0] = coolTemp;
      oldTemps[segments - 1] = hotTemp;
      
      for (int i = 0; i < segments; i++) {
         System.out.print(oldTemps[i] + " ");
      } 
      System.out.println(); 
      
      do {  
         newTemps[0] = coolTemp;
         newTemps[segments - 1] = hotTemp;
         
         for (int k = 1; k < segments; k++) {
            oldTemps[k] = newTemps[k];
         }   
      
         for (int i = 1; i < segments - 1; i++) {
            newTemps[i] = sumAll(oldTemps[i - 1], oldTemps[i + 1]);            
         }
         
         System.out.println();
         for (int i = 0; i < segments; i++) {
            System.out.printf("%.3f", newTemps[i]);
            System.out.print(" ");
         } 
          
      } while (equality(oldTemps, newTemps, epsilon));
         
      for (int k = 1; k < segments; k++) {
         oldTemps[k] = newTemps[k];
      }     
     
      System.out.println();
      
      for (int i = 0; i < segments; i++) {
         System.out.printf("%.3f", newTemps[i]);
         System.out.print(" ");
      } 
   } //end of main
   
   
         
   
   
} //end of program
