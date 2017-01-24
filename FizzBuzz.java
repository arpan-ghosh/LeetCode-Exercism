/*
 * Write a program that outputs the string  
 * representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” 
 * instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	    private static List<String> list = new ArrayList<String>();
	    private static String numString = "";
	    private static int count = 1;
	    	    
		public static List<String> fizzBuzz(int n) {
			
			for (int i = n; i > 0; i--) {
	    		numString = String.valueOf(count);
	    		
				if ((count % 3 == 0) && (count % 5 == 0)) {
	    			list.add("FizzBuzz");
	    		} else if (count % 3 == 0) {
	    			list.add("Fizz");
	    		} else if (count % 5 == 0) {
	    			list.add("Buzz");
	    		} else {
	    			list.add(numString);
	    		}
	    		count++;
			}
			return list;	        
	    }
		    
	    public static void main (String[] args) {
	    	fizzBuzz(15);
	    	list.stream().forEach(System.out::println);
	    }
	
}
