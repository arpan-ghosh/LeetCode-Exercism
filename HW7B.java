/* SAMPLE INPUT:

5 5
CCCCC
C....
C..H.
C..H.
C....
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/** Giant program that inputs a file FULL of "h's", "c's" and ".'s".
* Reads that file. Puts everything into a three dimensional array.
* If one of those pieces is a '.', its unrestricted, and must be fixed.
* The "H" and "C" temperatures are provided, so convert all "H" and "C"
* values from the insourced array into those given numbers. Then the ".'s"
* are zeroes. Then continually average the ".'s" until those numbers are 
* stabilized. You're going to then return just the original array (with the
* defined "H" doubles, "C" doubles and 0.0's), a line space, then the new array
* full of the averaged, stabilized doubles.
*/
public class HW7B {

   static char[][] copy;

   public static boolean equalMethod(double[][] array1, double[][] array2, double epsilon) {
   
      for (int i = 0; i < array1.length;){
         for (int j = 0; j < array1[0].length;) {
         
            if (array1[i][j] - array2[i][j] == 0.0) {
               j++;
            }
            else if (array1[i][j] - array2[i][j] > epsilon) {
               j++;
            }
            else if (array1[i][j] - array2[i][j] < -1 * epsilon) {
               j++;
            } 
            else {
               return false;
            }
            i++;
         }
         //i++;
         return false;
      }
      return true;
   }

   /** The main method to do all the dirtywork.
   * @param args not used
   * @throws IOException if something dirty happens
   * @throws FileNotFoundException because there mightn't be a file at all
   */
   public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {
   
      final double epsilon = 0.001;
   
      int width;
      int height;
      int arrayWidth;
      int arrayHeight;
   
      double cool;
      double hot;
      Scanner readMe = new Scanner(System.in);
      //input "H" values, "C" values and file name
      System.out.println("enter cool temp, hot temp and input file name");
      cool = readMe.nextDouble();
      hot = readMe.nextDouble();
      String intFile = readMe.next();
      
      
      //start reading that input file
      Scanner filescan = new Scanner(new FileReader(intFile + ".txt"));
      //Before filling in homeArray, must initilize it.
      //It's a good thing the dimensions are already given!
      int rowCount = filescan.nextInt();
      int colCount = filescan.nextInt();
      String[][] homeArray = new String[rowCount][colCount];
      
      String line = filescan.nextLine();
      Scanner scanNumber = new Scanner(line);
      
      Scanner scanner = new Scanner(new File(intFile + ".txt"));
      height = scanner.nextInt();
      //System.out.println(height);
      width = scanner.nextInt();
     // System.out.println(width);
   
      char[][] copy = new char[height][width];
   
      String origLine = "";
      
      int counter = 0;
      
      while (scanner.hasNextLine()) {
                    
         for (int row = 0; row < rowCount; row++) {
            String words = scanner.nextLine();
            int size = Math.min(words.length(),width);    
            for (int i = 0; i < size; i++) {
               copy[row][i] = words.charAt(i);
            }
         }
      
      }
      
      //change values to double
      double[][] trollArray = new double[rowCount][colCount];
      
      
      for (int c = 0; c < copy.length; c++) {
         for (int d = 0; d < copy[c].length; d++) {
            if (copy[c][d] == 'H') {
               trollArray[c][d] += hot;
            }
            if (copy[c][d] == 'C') {
               trollArray[c][d] += cool;
            }
           
         }
          
      } 
   
      for(int i = 0; i < trollArray.length; i++) {
         for(int j = 0; j < trollArray[i].length; j++) {
            System.out.print(trollArray[i][j]);
            if (j < trollArray[i].length - 1) {
               System.out.print("     ");
            }
         }
         System.out.println();
      }
      System.out.println();
   
   //starting to average numbers
      int base = 0;
      int oldRow = trollArray.length;
      int oldCol = trollArray[0].length;
      double[][] sum = new double [oldRow][oldCol];
      double[][] sumNew = new double [oldRow][oldCol];
   
      do {
      
      
      //top left corner
         if (trollArray[0][0] == 0) {
            sum[0][0] = (trollArray[0][1] + trollArray[1][0]) / 2;
         }
      
      //top right corner
         if (trollArray[0][oldRow - 1] == 0) {
            sum[0][oldRow] = (trollArray[0][oldRow - 1] + trollArray[1][oldRow -1]) / 2;
         }
      
      //bottom left corner
         if (trollArray[oldRow - 1][0] == 0) {
            sum[oldRow - 1][0] = (trollArray[oldRow - 2][0] + trollArray[oldRow -1][1]) / 2;
         }
      
      //bottom right corner
         if (trollArray[oldRow - 1][oldCol - 1] == 0) {
            sum[oldRow - 1][oldCol - 1] = (trollArray[oldRow - 1][oldCol - 1] + trollArray[oldRow - 2][oldCol - 1]) / 2;
         }
      
      //top row between top corners
         for(int i = 1; i < trollArray.length - 2; i++){
               if (trollArray[0][i] == 0) {
                  sum[0][i] = (trollArray[0][i - 1] + trollArray[0][i + 1] + trollArray[0][0]) / 3;
               }
            }
         
      
      //bottom row between bottom corners
         for(int i = oldRow - 1; i < oldCol; i++){
            for(int j = 1; j < oldCol; j++){
               if (trollArray[i][j] == 0) {
                  sum[i][j] = (trollArray[i][j - 1] + trollArray[i][j + 1] + trollArray[i - 1][j]) / 3;
               }
            }
         }
      
      //right column between top left and bottom left corners
         for (int j = 0; j < oldRow; j++) {
            for(int i = 1; i < oldRow - 1; i++){
               if (trollArray[i][j] == 0) {
                  sum[i][j] = (trollArray[i - 1][j] + trollArray[i + 1][j] + trollArray[i][j + 1]) / 3;
               }
            }
         }
      
      //left column between top right and bottom right corners
         for (int j = oldCol - 1; j < oldRow; j++) {
            for (int i = 1; i < oldRow - 1; i++) {
               if (trollArray[i][j] == 0) {
                  sum[i][j] = (trollArray[i - 1][j] + trollArray[i + 1][j] + trollArray[i][j - 1]) / 3;
               }
            }
         }
      
      //the middle
         for (int i = 1; i < oldRow - 1; i++) {
            for (int j = 1; j < oldCol - 1; j++) {
               if (trollArray[i][j] == 0) {
                  sum[i][j] = (trollArray[i - 1][j] + trollArray[i + 1][j] + trollArray[i][j - 1] + trollArray[i][j + 1]) / 4;
               }
            }
         }
         
         for(int i = 0; i < sum.length; i++) {
         for(int j = 0; j < sum[i].length; j++) {
            System.out.print(sum[i][j]);
            if (j < sum[i].length - 1) {
               System.out.print("     ");
            }
         }
         System.out.println("");
      }
      System.out.println();
      
      }while(equalMethod(sum, sumNew, epsilon));
   
      for (int i = 0; i < oldRow; i++) {
         for (int j = 0; j < oldCol; j++) {
            sumNew[i][j] = sum[i][j];
         }
      }
        
                
      System.out.println("--------------------------------");
    
      for(int i = 0; i < sumNew.length; i++) {
         for(int j = 0; j < sumNew[i].length; j++) {
            System.out.print(sumNew[i][j]);
            if (j < sumNew[i].length - 1) {
               System.out.print("     ");
            }
         }
         System.out.println();
      }
   
   
      
   } //end of main

} //end of program