/*
 * This class handles our JFreeChart program. It reads the CSV files made by our PSS, then stores them into XYSeries to then be plotted using a ChartFactory
 * 
 * @author Juan Villaman
 */
package com.juanvillaman.jfreechart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JFreeChartsGraphing {
  
  /*
   * This method uses JFreeCharts to create a visual graph of our original plotted data, the salted data, and the smoothed data
   * Video Tutorial used for JFreeChart and how to use ChartFactory: https://youtu.be/skxH0oX6XlI?list=PLS1QulWo1RIbx1dvFMTFOMxzAmO28Qoc9
   */
  public void plotGraphs(){
    XYSeries originalGraph = loadCSV("Plotter-Data.csv", "Original");
    XYSeries saltedGraph = loadCSV("Salted-Data.csv", "Salted");
    XYSeries smoothedGraph = loadCSV("Smoothed-Data.csv", "Smoothed");

    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(originalGraph);
    dataset.addSeries(saltedGraph);
    dataset.addSeries(smoothedGraph);

    JFreeChart chart = ChartFactory.createXYLineChart(
      "Original vs Salted vs Smoothed",
      "X",
      "Y",
      dataset,
      PlotOrientation.VERTICAL,
      true,
      true,
      false
    );

    // Video Tutorial used for JFrame (Official Java documentation was used as well): https://youtu.be/5o3fMLPY7qY
    JFrame frame = new JFrame("Original vs Salted vs Smoothed");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new ChartPanel(chart));
    frame.setSize(1280, 720); //1280px by 720px window
    frame.setVisible(true);
  }

  /*
   * This method reads the CSV files from our plotter, salter, and smoother and stores them into an XYSeries to eventually plot them
   * 
   * @param String filename - this is the name of any of our CSV files created by our PSS
   * @param String label - this is the label given to the line in the XYSeries
   * @return series - returns the series that now has the values from our CSV files
   */
  public static XYSeries loadCSV(String filename, String label) {
    XYSeries series = new XYSeries(label);
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.toLowerCase().contains("x")) continue; // This line skips the header (since every CSV file begins with X)
        String[] vals = line.split(",");
        if (vals.length >= 2) {
          double x = Double.parseDouble(vals[0].trim());
          double y = Double.parseDouble(vals[1].trim());
          series.add(x, y);
        }
      }
    }catch (IOException e) {
        System.err.println("Failed to load " + filename + ": " + e.getMessage());
    }
    return series;
  }
}

