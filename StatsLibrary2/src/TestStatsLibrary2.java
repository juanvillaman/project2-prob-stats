/*
 * This is the tester class for the second Stats Library that runs the results of our formulas
 * 
 * @author Juan Villaman
 */
public class TestStatsLibrary2 {
  public static void main(String[] args) {
    
    StatsLibrary2 stats = new StatsLibrary2();
    System.out.println("Welcome to my second StatLibrary! Below are some of the formulas calculated.");

    System.out.println();

    double poissonProbResult = stats.poissonProbability(4, 2);
    System.out.println("Poisson Probability Result with λ = 4, and y = 2: " + poissonProbResult);

    System.out.println();

    double expectedPoissonValue = stats.expectedPoisson(4);
    System.out.println("Expected Value for Poisson (λ = 4): " + expectedPoissonValue);

    System.out.println();

    double variancePoissonValue = stats.variancePoisson(4);
    System.out.println("Varaince for Poisson (λ = 4): " + variancePoissonValue);

    System.out.println();

    double chebyInside = stats.tchebysheffsTheorem(2, false);
    System.out.println("Tchebysheff's Theorem (Inside Bound, k = 2): " + chebyInside);

    System.out.println();

    double chebyOutside = stats.tchebysheffsTheorem(2, true);
    System.out.println("Tchebysheff's Theorem (Outside Bound, k = 2): " + chebyOutside);
  }
}
