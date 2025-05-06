/*
 * This class holds our method which will uses the Apache Stats Library in order to test some functionality of the library
 * 
 * @author Juan Villaman
 */
package com.juanvillaman.jfreechart;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.HypergeometricDistribution;


public class ApacheFunctions {
  
  private double[] data;

  /*
   * Constructor that holds our array of data
   */
  public ApacheFunctions(double[] data){
    this.data = data;
  }

  /*
   * This method handles all of the calculations that we are showcasing, like the mean, standard deviation, min/max, and median
   * Showcasing also different kinds of distributions
   */
  public void run(){
    DescriptiveStatistics stats = new DescriptiveStatistics();
    for(double value : data){
      stats.addValue(value);
    }
    
    double mean = stats.getMean();
    double standardDev = stats.getStandardDeviation();

    System.out.println("-----Using Apache to Calculate These Values from our Data!-----");
    System.out.println("Mean: " + mean);
    System.out.println("Standadrd Deviation of our Data: " + stats.getStandardDeviation());
    System.out.println("Minimum Value of our Data: " + stats.getMin());
    System.out.println("Maximum Value of Our Data: " + stats.getMax());
    System.out.println("Median Value: " + stats.getPercentile(50));

    System.out.println();

    System.out.println("-----Distributions We Can Solve With Apache (Not all Distributions shown)-----");
    NormalDistribution normalDist = new NormalDistribution(mean, standardDev);
    System.out.println("Normal Distribution (P(2 < Y < 4)): " + normalDist.probability(2.0, 4.0));

    int lambda = (int) Math.round(mean);
    PoissonDistribution poissonDist = new PoissonDistribution(lambda);
    System.out.println("Poisson Probability P(Y = 3): " + poissonDist.probability(3));

    BinomialDistribution binomialDist = new BinomialDistribution(10, 0.5);
    System.out.println("Binomial Distribution (P(Y = 5)): " + binomialDist.probability(5));

    HypergeometricDistribution hyperDist = new HypergeometricDistribution(20, 7, 5);
    System.out.println("Hypergeometric Distributino P(Y = 2): "+ hyperDist.probability(2));
  }
}
