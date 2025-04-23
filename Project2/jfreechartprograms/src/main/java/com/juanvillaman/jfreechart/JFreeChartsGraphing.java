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
  
  public void plotGraphs(){
    XYSeries original = loadCSV("Plotter-Data.csv", "Original");
    XYSeries salted = loadCSV("Salted-Data.csv", "Salted");
    XYSeries smoothed = loadCSV("Smoothed-Data.csv", "Smoothed");

    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(original);
    dataset.addSeries(salted);
    dataset.addSeries(smoothed);

    JFreeChart chart = ChartFactory.createXYLineChart("Original vs Salted vs Smoothed", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);

    JFrame frame = new JFrame("Data Comparison");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new ChartPanel(chart));
    frame.setSize(800, 600);
    frame.setVisible(true);
  }

  private static XYSeries loadCSV(String filename, String label) {
    XYSeries series = new XYSeries(label);
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.toLowerCase().contains("x")) continue; // skip header
          String[] parts = line.split(",");
          if (parts.length >= 2) {
            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());
            series.add(x, y);
          }
      }
    } catch (IOException e) {
        System.err.println("Failed to load " + filename + ": " + e.getMessage());
      }
      return series;
    }
}

