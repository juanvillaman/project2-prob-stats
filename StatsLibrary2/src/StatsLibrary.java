/*
 * This class is the main StatsLibrary that holds all of the formulas studied so far in our semester
 * 
 * @author Juan Villaman
 */
import java.math.BigInteger;
import java.util.*;

public class StatsLibrary {
  
  /*
   * This method calculates the mean of an array of integers
   * 
   * @param int[] userInputNumbers - this is the array of numbers that the mean will be calculated from
   * @return result - the mean of the array of integers
   */
  public double getMean(int[] userInputNumbers){
    int total = 0;
    for(int singleNumber : userInputNumbers){
      total += singleNumber;
    }
    double result = (double) total / userInputNumbers.length;
    return result;
  }

  /*
   * This method calculates the media of an array of integers. Handles cases if the array length is even or odd
   * 
   * @param int[] userInputNumbers - this is the array of numbers that the median will be calculated from
   * @return result - the median of the array of integers
   */
  public double getMedian(int[] userInputNumbers){
    Arrays.sort(userInputNumbers);

    int n = userInputNumbers.length;

    if (n % 2 == 0){
      return (userInputNumbers[n / 2 - 1] + userInputNumbers[n / 2]) / 2.0;
    }
    else{
      return userInputNumbers[n / 2];
    }
  }

  /*
   * This method determines the mode of an array of integers
   * 
   * @param int[] userInputNumbers - the array of numbers that the mode will be acquired from
   * @return mode - the mode of the array of integers
   */
  public double getMode(int[] userInputNumbers){
    int mode = userInputNumbers[0];
    int maxCount = 0;

    for (int i = 0; i < userInputNumbers.length; i++) {
        int count = 0;
        for (int j = 0; j < userInputNumbers.length; j++) {
            if (userInputNumbers[i] == userInputNumbers[j]) {
                count++;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            mode = userInputNumbers[i];
        }
    }
    return mode;
  }

  /*
   * This method calculates the factorial of a number (ex. 5!, read as "5 factorial")
   * 
   * @param double n - this is the number we are calculating the factorial from
   * @return result - this is the factorial result of the number we chose
   */
  public double factorial(int n){
    double result = 1;
    for(int i = 2; i <= n; i++){
      result *= i;
    }
    return result;
  }

  /*
   * This method calculates the factorial of a number (ex. 5!, read as "5 factorial"). This is meant to handle larger than usual numbers, hence using long instead of double.
   * 
   * @param double n - this is the number we are calculating the factorial from
   * @return result - this is the factorial result of the number we chose
   */
  public long longFactorial(long n){
    long result = 1;
    for(int i = 2; i <= n; i++){
      result *= i;
    }
    return result;
  }

  /*
   * This method calculates the factorial of a number (ex. 5!, read as "5 factorial"). This is meant to handle larger than usual numbers, hence using BigInteger instead of double.
   * 
   * @param double n - this is the number we are calculating the factorial from
   * @return result - this is the factorial result of the number we chose
   */
  public BigInteger bigFactorial(int n){
    BigInteger result = new BigInteger("1");
    for(int i = 2; i <= n; i++){
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }

  /*
   * This method calculates the standard deviation of an array of integers
   * 
   * @param int[] userInputNumbers - the array of integers the standard deviation is being calculated from
   * @return stdDev - the standard deviation of that array
   */
  public double getStdDeviation(int[] userInputNumbers){
    double mean = getMean(userInputNumbers);
    int n = userInputNumbers.length;
    
    int numberResult = 0;
    for(int i = 0; i < n; i++){
      //This first gets the numbers of the array and subtract the mean from them, then squaring it. Then they are added together to this one variable
      numberResult += Math.pow(userInputNumbers[i] - mean, 2);
    }

    //This is the final step to get our standard deviation
    double stdDev = Math.sqrt(numberResult / n);
    return stdDev;
  }

  /*
   * This method calculates the Combinations needed
   * 
   * @param n - total number of objects
   * @param r - number of objects to be chosen
   * @return combinations - the result of the combinations formula (nCr = n! / (r!(n - r)!)).
   */
  public double getCombination(int n, int r){
    double combinations = factorial(n) / (factorial(r) * factorial(n - r));
    return combinations;
  }

  /*
   * This method calculates the Combinations needed. Use is intended for larger numbers
   * 
   * @param n - total number of objects
   * @param r - number of objects to be chosen
   * @return combinations - the result of the combinations formula (nCr = n! / (r!(n - r)!)).
   */
  public long longCombination(int n, int r){
    long combinations = longFactorial(n) / (longFactorial(r) * longFactorial(n - r));
    return combinations;
  }

  /*
   * This method calculates the Combinations needed. Use is intended the largest numbers
   * 
   * @param n - total number of objects
   * @param r - number of objects to be chosen
   * @return combinations - the result of the combinations formula (nCr = n! / (r!(n - r)!)).
   */
  public BigInteger bigCombination(int n, int r){
    BigInteger combinations = bigFactorial(n).divide((bigFactorial(r)).multiply(bigFactorial(n - r)));
    return combinations;
  }

  /*
   * This method calculates the Permuations needed
   * 
   * @param n - total number of objects
   * @param r - number of objects to be chosen
   * @return permutations - the result of the permutations formula (nPr = n! / (n - r)!).
   */
  public double getPermutation(int n, int r){
    double permutations = factorial(n) / (factorial(n - r));
    return permutations;
  }

  /*
   * This method calculates the Permuations needed. Use intended for larger numbers
   * 
   * @param n - total number of objects
   * @param r - number of objects to be chosen
   * @return permutations - the result of the permutations formula (nPr = n! / (n - r)!).
   */
  public long longPermutation(int n, int r){
    long permutations = longFactorial(n) / (longFactorial(n - r));
    return permutations;
  }

  /*
   * This method calculates the Permuations needed. Use intended for the largest numbers
   * 
   * @param n - total number of objects
   * @param r - number of objects to be chosen
   * @return permutations - the result of the permutations formula (nPr = n! / (n - r)!).
   */
  public BigInteger bigPermutation(int n, int r){
    BigInteger permutations = bigFactorial(n).divide(bigFactorial(n - r));
    return permutations;
  }

  /*
   * This method calculates conditional probability (Probability of event A given that event B has happened)
   * 
   * @param double probabilityB - this is the probability of event B, needed for the formula
   * @param double probabilityAandB - this is the intersection of the probabilities of A and B
   * @return conditionalProbability - the conditional probability of event A and B 
   */
  public double conditionalProbability(double probabilityB, double probabilityAandB){
    if(probabilityB == 0){
      throw new IllegalArgumentException("Probability of B cannot be 0 (Probability of B is the denominator)");
    }
    double conditionalProbability = probabilityAandB / probabilityB;
    return conditionalProbability;
  }

  /*
   * This method checks if two events are dependent on each other or independent from each other
   * 
   * @param probabilityA - probability of event A
   * @param probabilityB - probability of event B
   * @param probabilityAandB - probability of event A and B
   * @return "Independent"/"Dependent" - This returns whether the events are independent or dependent
   */
  public String checkIndependence(double probabilityA, double probabilityB, double probabilityAandB){
    if(conditionalProbability(probabilityAandB, probabilityAandB) == probabilityA){
      return "Independent";
    }
    if(conditionalProbability(probabilityAandB, probabilityA) == probabilityB){
      return "Independent";
    }
    if(probabilityAandB == probabilityA * probabilityB){
      return "Independent";
    }
    return "Dependent";
  }

  /*
   * This method handles the multiplicative law. It also handles events where the events are dependent and independent.
   * 
   * @param probabilityA - probability of event A
   * @param probabilityB - probability of event B
   * @param probabilityAandB - probability of event A and B
   * return multiplicativeLaw / aGivenB*probabilityB - this is the result of the multiplicative law, handling dependency as well 
   */
  public double multiplicativeLaw(double probabilityA, double probabilityB, double probabilityAandB){
    String dependence = checkIndependence(probabilityA, probabilityB, probabilityAandB);

    if(dependence.equals("Independent")){
      double multiplicativeLaw = probabilityA * probabilityB;
      return multiplicativeLaw;
    } else {
      double aGivenB = conditionalProbability(probabilityAandB, probabilityB);
      return aGivenB * probabilityB;
    }
  }

  /*
   * This method handles the additive law for probabilities of events A and B
   * 
   * @param probabilityA - probability of event A
   * @param probabilityB - probability of event B
   * @param probabilityAandB - probability of event A and B
   * @return additiveLaw - this is the additive law formula (P(A u B) = P(A) + P(B) - P(A ∩ B))
   */
  public double additiveLaw(double probabilityA, double probabilityB, double probabilityAandB){
    double additiveLaw = probabilityA + probabilityB - probabilityAandB;
    return additiveLaw;
  }

  /*
   * This method handles the additive law for probabilities of events A and B
   * 
   * @param probabilityA - probability of event A
   * @param probabilityB - probability of event B
   * @param probabilityAandB - probability of event A and B
   * @return bayesTheorem - this is the formula for bayesTheorem ((P(B | A) * P(A))/ P(B))
   */
  public double bayesTheorem(double bGivenA, double probabilityA, double probabilityB){
    double bayesTheorem = (bGivenA * probabilityA) / probabilityB;
    return bayesTheorem;
  }

  /*
   * This method calculates the binomial distribution probability
   * 
   * @param int n - total number of trials
   * @param int y - number of successes in the trials
   * @param double p - probability of success in a trial
   * @return binomialDistribution - this returns the formula for binomial distribution
   */
  public double binomialDistribution(int n, int y, double p){
    long combinations = longCombination(n, y);
    double success = Math.pow(p, y);
    double failure = Math.pow((1 - p), (n - y));
    double binomialDistribution = combinations * success * failure;

    return binomialDistribution;
  }

  /*
   * This method calculates the variance if Y is a random variable with binomial distribution
   * 
   * @param int n - total number of trials
   * @param double p - probability of success in a trial
   * @return the formula of variance if Y has binomial distribution
   */
  public double binomialVariance(int n, double p){
    return (double) n * p * (1 - p);
  }

  /*
   * This method calculates the expected value of Y if it has binomial distribution
   * 
   * @param int n - total number of trials
   * @param double p - probability of success
   * @return formula expected value of Y if it has binomial distribution
   */
  public double expectedBinomial(int n, double p){
    return (double) n * p;
  }

  /*
   * This method calculates the geometric distribution probability
   * 
   * @param int y - number of successes in the trials
   * @param double p - probability of success in a trial
   * @return geometricDistribution - this returns the formula for geometric distribution
   */
  public double geometricDistribution(int y, double p){
    double geometricDistribution = Math.pow((1 - p), (y - 1)) * p;
    return geometricDistribution;
  }

  /*
   * This method calculates the variance if Y is a random variable with geometric distribution
   * 
   * @param double p - probability of success in a trial
   * @return the formula of variance if Y has geometric distribution
   */
  public double geometricVariance(double p){
    return (1 - p) / Math.pow(p, 2);
  }
  
  /*
   * This method calculates the expected value of Y if it has geometric distribution
   * 
   * @param double p - probability of success
   * @return the formula of the expected value of Y
   */
  public double expectedGeometric(double p){
    return 1 / p;
  }

  /*
   * This method calculates the hypergeometric distribution probability
   * 
   * @param int N - total population size
   * @param int r - number of successes in the population
   * @param int n - size drawn from the population
   * @param int y - number of successes in the sample drawn (n)
   * @return hypergeometricDistribution - this returns the formula for hypergeometric distribution
   */
  public double hypergeometricDistribution(int N, int r, int n, int y){
    long num = longCombination(r, y) * longCombination(N - r, n - y);
    long dem = longCombination(N, n);
    double hypergeometricDistribution = (long) num / dem;
    
    return hypergeometricDistribution;
  }

  /*
   * This method calculates the variance if Y is a random variable with hypergeometric distribution
   * 
   * @param int N - total population size
   * @param int n - size drawn from the population
   * @param int r - number of successes in the population
   * @return the formula for variance if Y has hypergeometric distribution
   */
  public double hypergeometricVariance(int N, int n, int r){
    return (double) n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1));
  }

  /*
   * This method calculates the expected value of Y if it has a hypergeometric distribution
   * 
   * @param int n - size drawn from the population
   * @param int r - number of successes in the population
   * @param int N - total population size
   * @return the formula for the expected value of Y if it has HGD
   */
  public double expectedHyperGeometric(int n, int r, int N){
    return (double) (n * r) / N;
  }

  /*
   * This method calculates the negative binomial distribution probability
   * 
   * @param int r - number of successes required
   * @param int y - number of failures before achieving r successes
   * @param double p - probability of success in each trial
   * @return hypergeometricDistribution - this returns the formula for hypergeometric distribution
   */
  public double negativeBinomialDist(int y, int r, double p){
    long combinations = longCombination(y - 1, r - 1);
    long success = (long) Math.pow(p, r);
    long failure = (long) Math.pow(1 - p, y - r);
    double negativeBinomialDist = (long) combinations * success * failure;
    
    return negativeBinomialDist;
  }

  /*
   * This method calculates the variance if Y is a random variable with a negative binomial distribution
   * 
   * @param int r - number of successes required
   * @param double p - probability of success in each trial
   * @return r / p - this is the formula for variance for negative binomial distribution
   */
  public double negativeBinomialVariance(int r, double p){
    return (double) (r*(1 - p)) / (Math.pow(p, 2));
  }

  /*
   * This method calculates the expected value of Y if it has a negative binomial distribution
   * 
   * @param int r - number of successes required
   * @param double p - probability of success in each trial
   * @return the formula for the expected value of Y if it has a NBD
   */
  public double expectedNegativeBinomial(int r, double p){
    return (double) r / p;
  }
}
