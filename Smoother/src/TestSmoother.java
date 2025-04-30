/*
 * This is our main method which smooths our data and creates the new CSV file where the smoothed data is stored
 * 
 * @author Juan Villaman
 */
public class TestSmoother {
  public static void main(String[] args) {
    Smoother test = new Smoother();
    test.smoothData(20);
  }
}
