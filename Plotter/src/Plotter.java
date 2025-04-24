/*
 * This is my Plotter class which plots the quadratic equation ax^2 + bx + c and writes those values to a CSV file
 * The coefficients are chosen by the user to make the Plotter be able to plot different numbers
 * 
 * @author Juan Villaman
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Plotter {
  
  /*
   * These ArrayLists hold our values needed for our CSV
   */
  private ArrayList<Double> xValues = new ArrayList<>();
  private ArrayList<Double> yValues = new ArrayList<>();

  /*
   * This method "plots" our data by using a loop that calculates the y value of the quadratic equation using a range of x that we can set
   * This method also asks the user to input the coefficients of the equation, making customizeable if the user wants to see different numbers
   */
  public void plotData(){
    Scanner in = new Scanner(System.in);

    System.out.println("You're selecting the coefficient values for the quadratic equation to be plotted: ax^2 + bx + c");

    System.out.print("Enter coefficient a: ");
    double a = in.nextDouble();

    System.out.print("Enter coefficient b: ");
    double b = in.nextDouble();

    System.out.print("Enter coefficient c: ");
    double c = in.nextDouble();

    // This line plots the quadratic formula from -100 <= x <= 100
    for(double x = -100; x <= 100; x += 1){
      double y = a * x * x + b * x + c; // y = ax^2 + bx + c
      xValues.add(x);
      yValues.add(y);
    }

    writeCSV("Plotter-Data.csv");

    in.close();
  }

  /*
   * This method writes the CSV files with our X and Y values of our quadratic equation
   * Video Tutorial used for writing a CSV files: https://youtu.be/dHZaqMmQNO4
   * 
   * @param String filename - this is the name of our CSV file that our data will be in
   */
  public void writeCSV(String filename){
    try (PrintWriter out = new PrintWriter(filename)){
      out.println("X,Y");
      for (int i = 0; i < xValues.size(); i++){
        out.printf("%.2f,%.2f%n", xValues.get(i), yValues.get(i));
      }
      System.out.println("Plotted Data has been written to " + filename);
    } catch (FileNotFoundException e){
      System.out.println("Error writing file: " + e.getMessage());
    }
  }
}
