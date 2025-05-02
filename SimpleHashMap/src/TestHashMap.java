/*
 * This class tests our SimpleHashMap implementation by hashing a large file of text and seeing the time it took and memory usage
 * 
 * @author Juan Villaman
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TestHashMap {
  public static void main(String[] args) throws IOException {

    SimpleHashMap map = new SimpleHashMap(1000);

    Runtime runtime = Runtime.getRuntime();
    runtime.gc();
    
    //Starts the capture of our time and memory usage before hashing out input.txt file
    long startMemory = runtime.totalMemory() - runtime.freeMemory();
    long startTime = System.nanoTime();

    PrintWriter log = new PrintWriter("Load-Factor-Time-Memory.csv");
    log.println("LoadFactor,TimeMs,MemoryKB");

    //Video Tutorial on how to use basic BufferedReader: https://youtu.be/eHjbvgw4hsI?t=281
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    String line;
    int processed = 0;
    while((line = reader.readLine()) != null){
      //This line cleans up the text. "Hello!?1234" -> "hello" and stores them in an array
      String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
      for(String word : words){
        if(!word.isEmpty()){
          map.addWord(word);
          processed++;

          //This logs our load factor, elapsed time, and used memory every 10,000 words processed and writes it to our CSV
          if(processed % 10000 == 0){
            double loadFactor = (double) map.getSize() / map.getBucketCount();
            long currentTime = System.nanoTime();
            double elapsedMs = (currentTime - startTime) / 1_000_000.0;
            long currentMemory = runtime.totalMemory() - runtime.freeMemory();
            long usedMemory = currentMemory - startMemory;

            log.printf("%.4f,%.2f,%.2f\n", loadFactor, elapsedMs, usedMemory / 1024.0);
          }
        }
      }
    }
    reader.close();
    log.close();

    long endTime = System.nanoTime();
    long endMemory = runtime.totalMemory() - runtime.freeMemory();
    //Ends the capture of our time and memory usage after hashing out input.txt file

    System.out.printf("Time taken: %.2f ms\n", (endTime - startTime) / 1_000_000.0);
    System.out.printf("Memory used: %.2f KB\n", (endMemory - startMemory) / 1024.0);
  }
}
