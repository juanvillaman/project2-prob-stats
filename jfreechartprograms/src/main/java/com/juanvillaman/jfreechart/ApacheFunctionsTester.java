/*
 * Tester class which displays our results gotten from the Apache Stats Library
 * 
 * @author Juan Villaman
 */
package com.juanvillaman.jfreechart;

public class ApacheFunctionsTester {
  public static void main(String[] args) {
    double data[] = {1.4, 2.5, 6.8, 2.6, 2.5, 2.5, 0.9, 7.43, 5.1, 2.73};
    ApacheFunctions test = new ApacheFunctions(data);
    test.run();
  }
}
