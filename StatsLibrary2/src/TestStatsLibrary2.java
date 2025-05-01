/*
 * This is the tester class for the second Stats Library that runs the results of our formulas
 * 
 * @author Juan Villaman
 */
public class TestStatsLibrary2 {
  
  public static void main(String[] args) {
    
    StatsLibrary2 stats = new StatsLibrary2();

    double poissonProbResult = stats.poissonProbability(4, 2);
    System.out.println("Poisson Probability Result with Lambda = 4, and y = 2: " + poissonProbResult);
  }
}
