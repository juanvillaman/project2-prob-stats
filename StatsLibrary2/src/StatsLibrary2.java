/*
 * This class is the second StatsLibrary that calculates formulas studied in the 2nd half of the semester
 * 
 * @author Juan Villaman
 */
public class StatsLibrary2 {
  
  /*
   * This method calculates Poisson Probability for problems that have that type of Probability
   * 
   * @param double lambda - average of rare events that occur in space, time, volume, or any other dimension
   * @param long y - the number Y of rare events that occur in space, time, volume or any other dimension
   * @return the formula for Poisson Proability: p(y) = ((λ^y)*(e^(-λ))) / y!, y = 0, 1, 2,..., λ > 0.
   */
  public double poissonProbability(double lambda, long y){
    StatsLibrary stats = new StatsLibrary();
    double numerator = Math.pow(lambda, y) * Math.exp(-lambda);
    double denominator = stats.longFactorial(y);
    return numerator / denominator;
  }

  /*
   * This method returns the average value of the Poisson Probability. By definition, lambda is already the average
   * 
   * @return lambda - This is the expected value of our Poisson Probability
   */
  public double expectedPoisson(double lambda){
    return lambda;
  }

  /*
   * This method returns the variance of the Poisson Probability. By definition, lambda is already the variance
   * 
   * @return lamba - This is the variance of our Poisson Probability.
   */
  public double variancePoisson(double lambda){
    return lambda;
  }

  /*
   * This is method calculates Tchebysheff's Theorem.
   * 
   * @param double k - the number of standard deviations from the mean (kσ)
   * @param boolean isOutside - this decides whether we are calculating our result from within our bounds, or outside
   * @return the formula for Tchebysheff's Theorem. If we are looking inside, 1 - (1 / k^2). Outside is 1 / k^2
   */
  public double tchebysheffsTheorem(double k, boolean isOutside){
    if(k <= 0){
      throw new IllegalArgumentException("k has to be greater than 0!");
    }

    if(isOutside){
      return 1 / Math.pow(k, 2);
    }else {
      return 1 - (1 / Math.pow(k, 2));
    }
  }

}
