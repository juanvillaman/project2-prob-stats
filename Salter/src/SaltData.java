/*
 * This class reads the CSV file made from our plotter, salts the Y values up and down randomly, and writes the values into a new CSV file
 * 
 * @author Juan Villaman
 */
import java.util.*;
import java.io.*;

public class SaltData {
  
  /*
   * These ArrayLists hold our values needed for our CSV
   */
  private ArrayList<Double> xPoints = new ArrayList<>();
  private ArrayList<Double> yPoints = new ArrayList<>();
  private ArrayList<Double> newY = new ArrayList<>();

  /*
   * This method reads the CSV, salts the values, and writes the CSV using helper methods written below. We can adjust our min and max for salting
   * This method allows the Main method to simply salt the data and create the CSV in one line
   */
  public void saltData() {
    readCSV("Plotter-Data.csv");
    saltYValues(1, 350);
    writeCSV("Salted-Data.csv");
  }

  /*
   * This method reads the CSV file made from our plotter, and splits the X and Y values using commas into an array. It makes sure that the values are numbers
   * Video Tutorial used to learn how to read a CSV file and effectively split the values: https://youtu.be/-Aud0cDh-J8?si=hnbeOBxP_GVrtQgg
   * 
   * @param String filePath - this is the path of our CSV file made by our Plotter
   */
  public void readCSV(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] vals = line.split(",");
          try {
            xPoints.add(Double.parseDouble(vals[0]));
            yPoints.add(Double.parseDouble(vals[1]));
          } catch (NumberFormatException e) {}
      }
    } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
  }

  /*
   * This method salts the Y values of our Plotter. Using a boolean that is randomly true or false, we subtract or add to our Y values, effectively salting our data
   * 
   * @param int min - this is the minimum that we can add or subtract from our Y values
   * @param int max - this is the maximum that we can add or subtract from our Y values
   */
  public void saltYValues(int min, int max) {
    Random rand = new Random();
    for (double y : yPoints) {
      int salt = rand.nextInt(max - min + 1) + min;
      boolean addSalt = rand.nextBoolean();
      if (addSalt) {
        newY.add(y + salt);
      } else {
          newY.add(y - salt);
      }
    }
  }

  /*
   * This method writes our new CSV files with our newly salted Y values
   * Video Tutorial used for writing CSV files - https://youtu.be/dHZaqMmQNO4
   * 
   * @param String filename - This is the name our salted data CSV file
   */
  public void writeCSV(String filename) {
    try (PrintWriter out = new PrintWriter(filename)) {
      out.println("X,Y");
      for (int i = 0; i < newY.size(); i++) {
        out.printf("%.2f,%.2f%n", xPoints.get(i), newY.get(i));
      }
        System.out.println("Salted data wrriten to " + filename);
      } catch (FileNotFoundException e) {
          System.out.println("Error writing file: " + e.getMessage());
    }
  }
}