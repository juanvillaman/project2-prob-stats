/*
 * This class reads the CSV file made from our Salter, smooths the Y values by using a 3-point moving average, and writes the values into a new CSV file
 * 
 * @author Juan Villaman
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Smoother {
  
  /*
   * These ArrayLists hold our values needed for our CSV
   */
  private ArrayList<Double> xValues = new ArrayList<>();
  private ArrayList<Double> yValues = new ArrayList<>();
  private ArrayList<Double> smoothedY = new ArrayList<>();

  /*
   * This method reads the CSV, smooths the values, and writes the CSV using helper methods written below.
   * This method allows the Main method to simply smooth the data and create the CSV in one line
   */
  public void smoothData(){
    readCSV("Salted-Data.csv");
    smoothYValues(25);
    writeCSV("Smoothed-Data.csv");
  }

  /*
   * This method reads the CSV file made from our salter, and splits the X and Y values using commas into an array. It makes sure that the values are numbers
   * Video Tutorial used to learn how to read a CSV file and effectively split the values: https://youtu.be/-Aud0cDh-J8?si=hnbeOBxP_GVrtQgg
   * 
   * @param String filePath - this is the path of our CSV file made by our Salter
   */
  public void readCSV(String filePath){
    try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
      String line;
      while((line = br.readLine()) != null){
        String[] vals = line.split(",");
        try{
          xValues.add(Double.parseDouble(vals[0]));
          yValues.add(Double.parseDouble(vals[1]));
        }catch (NumberFormatException e){}
      }
    } catch (IOException e){
      System.out.println("Error reading file: " + e.getMessage());
    }
  }

  /*
   * This method smooths our Y values using a 3-point moving average.
   * A 3-point moving average calculates our smoothed Y value by taking the average of the point itself, the neighbor before it, and the neighbor after
   * These 3 points are consecutive, and by taking the average of the three, we smooth our Y values
   * Edge-cases are handled for the first point of the data and the last point of the data
   */
  public void smoothYValues(int sims){
    for(int j = 0; j < sims; j++){
      ArrayList<Double> temp =  new ArrayList<>();
      for(int i = 0; i < yValues.size(); i++){
        double smoothed;
        if(i == 0){
          smoothed = (yValues.get(i) + yValues.get(i + 1)) / 2; //The beginning point
        }else if(i == yValues.size() - 1){
          smoothed = (yValues.get(i - 1) + yValues.get(i)) / 2; //The end point
        }else {
          smoothed = (yValues.get(i - 1) + yValues.get(i) + yValues.get(i + 1)) / 3; //All of the points in between
        }
        temp.add(smoothed);
      }
      yValues = new ArrayList<>(temp);
    }
    smoothedY = new ArrayList<>(yValues);
  }

  /*
   * This method writes our new CSV files with our newly smoothed Y values
   * Video Tutorial used for writing CSV files - https://youtu.be/dHZaqMmQNO4
   * 
   * @param String filename - This is the name of our smoothed data CSV file
   */
  public void writeCSV(String filename){
    try (PrintWriter out = new PrintWriter(filename)){
      out.println("X,Y");
      for (int i = 0; i < xValues.size(); i++){
        out.printf("%.2f,%.2f%n", xValues.get(i), smoothedY.get(i));
      }
      System.out.println("Smoothed Data has been written to " + filename);
    } catch (FileNotFoundException e){
      System.out.println("Error writing file: " + e.getMessage());
    }
  }
}
