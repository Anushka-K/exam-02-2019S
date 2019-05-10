package problem4;

import java.io.PrintWriter;
import java.util.Iterator;

/**
 * A quick experiment with hash tables.
 */
public class ChainedHashTableExperiment {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String[] strings = { "foxtrot", "horace", "koala", "violin" };
    Iterator<String> keys;
    ChainedHashTable<String,String> hash = 
      new ChainedHashTable<String,String>();
    for (String str : strings) {
      hash.set(str, str);
    } // for

    // This experiment is about deleting the first element in a 
    // bucket.
    pen.println("First experiment: Should print out 'horace koala violin'");
    keys = hash.keys();
    removeFirst(keys);
    printKeys(pen, keys);
    pen.println();

    // This experiment is about deleting an element after we've cleared
    // out one of the buckets
    pen.println("Second experiment: Should print out 'koala violin'");
    hash.set("gibbon", "gibbon");
    hash.set("gecko", "gecko");
    keys = hash.keys();
    removeFirst(keys); // gibbon in 11
    removeFirst(keys); // gecko in 25
    removeFirst(keys); // horace in 35
    printKeys(pen, keys);
    pen.println();

    // This experiment is about concurrent modification
    pen.println("Third experiment: Should throw a ConcurrentModificationException");
    hash.set("gecko", "gecko");
    hash.set("foxtrot", "foxtrot");
    keys = hash.keys();
    keys.next();        // Skip over gecko
    hash.remove("foxtrot");
    hash.set("gibbon", "gibbon");
    Iterator<String> values = hash.values();
    try {
      printKeys(pen, keys);
    } catch (Exception e) { 
      pen.println("Correctly threw an exception");
    } // try/catch
    pen.println();

    // FYI
    pen.println("Here's the final state of the hash table.");
    hash.dump(pen);
  } // main(String[])

  /**
   * Remove the first thing from an iterator.
   */
  static void removeFirst(Iterator<String> keys) {
    keys.next();
    keys.remove();
  } // removeFirst()

  /**
   * Print all of the remaining keys.
   */
  static void printKeys(PrintWriter pen, Iterator<String> keys) {
    while (keys.hasNext()) {
      pen.print(keys.next() + " ");
      pen.flush();
    } // while
    pen.println();
  } // printKeys

} // class ChainedHashTableExperiment
