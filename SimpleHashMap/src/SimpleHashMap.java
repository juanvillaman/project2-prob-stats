import java.util.LinkedList;

public class SimpleHashMap {
  
  /*
   * A static nested class that make objects that stores the word being hashed and its count
   */
  private static class WordCount{
    String word;
    int count;

    WordCount(String word){
      this.word = word;
      this.count = 1;
    }
  }

  /*
   * Global Variables needed in order to handle HashMap size
   */
  private LinkedList<WordCount>[] buckets;
  private int size = 0;
  private static final double LOAD_FACTOR = 0.75; //If 75% of the map is being used, it'll resize to fit more strings

  /*
   * This constructor initializes every our HashMap array. Every index in that array is a bucket, and that bucket is LinkedList
   * 
   * @param initialSize - this is the original size of our HashMap to store strings
   */
  @SuppressWarnings("unchecked")
  public SimpleHashMap(int initialSize){
    buckets = new LinkedList[initialSize];
    for(int i = 0; i < initialSize; i++){
      buckets[i] = new LinkedList<>();
    }
  }

  /*
   * This method hashes our words by checking each character to make sure it is a word, then counts the amount of letters in said words
   * This then returns the index where the (word, count) will be stored in our HashMap
   * 
   * @param String word - The word being hashed and stored in our hashmap with their letter count
   * @return letters % buckets.length - This is the index where our word will be stored in our HashMap. Modulo (%) used to prevent ArrayIndexOutOfBoundsException
   */
  public int simpleHash(String word){
    int letters = 0;
    for(int i = 0; i < word.length(); i++){
      if(Character.isLetter(word.charAt(i))){
        letters++;
      }
    }
    return letters % buckets.length;
  }

  /*
   * Method adds our word to a bucket in our map, it also increments the count of a word if it already exists. The word is added if is not already in our map
   * Also checks to see if our map needs to be resized when the load factor is exceeded (if more than 75% of our map is being used, resize)
   * 
   * @param String word - this is the word thats being added to our map
   */
  public void addWord(String word){
    int index = simpleHash(word);
    LinkedList<WordCount> list = buckets[index];

    for(WordCount wc : list){
      if(wc.word.equals(word)){
        wc.count++;
        return;
      }
    }
    list.add(new WordCount(word));
    size++;

    //Load Factor Explanation: https://www.geeksforgeeks.org/load-factor-in-hashmap-in-java-with-examples/
    if((double) size / buckets.length > LOAD_FACTOR){
      resize();
    }
  }

  /*
   * This method effectively doubles our HashMap size. It takes the old Map and makes a new map with double the size (oldBuckets.length * 2)
   * All of the words are rehashed into our newly resized map using addWord method.
   */
  @SuppressWarnings("unchecked")
  private void resize(){
    LinkedList<WordCount>[] oldBuckets = buckets; //Grabbing our map so we can double its size
    buckets = new LinkedList[oldBuckets.length * 2];
    for(int i = 0; i < buckets.length; i++){
      buckets[i] = new LinkedList<>();
    }
    size = 0; //Resetting the size to 0 (our new HashMap size before hashing all the words again)

    for(LinkedList<WordCount> list : oldBuckets){
      for(WordCount wc : list){
        //For-loop guarantees that the word is added to our map the correct amount of times (wc.count)
        for(int i = 0; i < wc.count; i++){
          addWord(wc.word);
        }
      }
    }
  }

  /*
   * This getter method gets the size of our map
   * 
   * @return size - size of our hashmap
   */
  public int getSize(){
    return size;
  }

  /*
   * This getter methods gets the amount of spots in hashmap
   * 
   * @return buckets.length - how many slots are in our map
   */
  public int getBucketCount(){
    return buckets.length;
  }
}
