/**
 * 
 */
package sEdwardsExercise4b;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Shane Edwards 
 * 
 *         Due : 10/16/2022 
 *         
 *         This program will read an input file, and on the output file display the total number of 
 *         contributions needed to meet the goal of 10 million dollars, 
 *         the amount of the largest and smallest contribution accepted,
 *         and the average contribution sized final total of the contributions accepted 
 *         
 *         This is entirely my own work with the following exceptions: None
 *
 *
 */
public class SEdwardsExercise4b {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	
	File file = new File("in");
	Scanner s = new Scanner(file);
	
	double max_contro = Double.MIN_VALUE;
    double min_contro = Double.MAX_VALUE;
    int total = 0;
    int goal = 10000000;
    double current = 0.0;
	
	while (s.hasNextLine()) {

		
		double amt = Double.parseDouble(s.nextLine());
        current  += amt;
        total++;
        if (amt < min_contro) {
            min_contro = amt;
        }
        if (amt > max_contro) {
            max_contro = amt;
        }
        if (current > goal) {
            break;
        }
    }
	double avg = Math.round((double) current / total);
	
	try {
	    FileWriter myWriter = new FileWriter("output");
	    myWriter.write("It took " + total + " contributions to reach the goal.");
	    myWriter.write(System.lineSeparator());
	    myWriter.write("The maximum contribution recevied was $" + max_contro);
	    myWriter.write(System.lineSeparator());
	    myWriter.write("The minimum contribution received was $" + min_contro);
	    myWriter.write(System.lineSeparator());
	    myWriter.write("The average contribution amount was $" + avg);
	    myWriter.write(System.lineSeparator());
	    myWriter.write("A total of $" + current + " was collected.");
	    myWriter.close();
	  } catch (IOException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	  }

	  try {
	      File myObj = new File("output");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
	
	
	
	
	