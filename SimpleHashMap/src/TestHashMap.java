import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestHashMap {
  public static void main(String[] args) throws IOException {
    SimpleHashMap map = new SimpleHashMap(1000);

    Runtime runtime = Runtime.getRuntime();
    runtime.gc();
    
    //Starts the capture of our time and memory usage before hashing out input.txt file
    long startMemory = runtime.totalMemory() - runtime.freeMemory();
    long startTime = System.nanoTime();

    //Video Tutorial on how to use basic BufferedReader: https://youtu.be/eHjbvgw4hsI?t=281
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    String line;
    while((line = reader.readLine()) != null){
      //This line cleans up the text. "Hello!?1234" -> "hello" and stores them in an array
      String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
      for(String word : words){
        if(!word.isEmpty()){
          map.addWord(word);
        }
      }
    }
    reader.close();

    long endTime = System.nanoTime();
    long endMemory = runtime.totalMemory() - runtime.freeMemory();
    //Ends the capture of our time and memory usage after hashing out input.txt file

    System.out.printf("Time taken: %.2f ms\n", (endTime - startTime) / 1_000_000.0);
    System.out.printf("Memory used: %.2f KB\n", (endMemory - startMemory) / 1024.0);
  }
}
