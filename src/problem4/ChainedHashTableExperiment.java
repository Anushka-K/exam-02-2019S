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
    ChainedHashTable<String,String> hash = 
      new ChainedHashTable<String,String>();
    for (String str : strings) {
      hash.set(str, str);
    } // for

    Iterator<String> keys = hash.keys();
    keys.next();
    keys.remove();
    while (keys.hasNext()) {
      pen.println(keys.next());
    } // while
  } // main(String[])
} // class ChainedHashTableExperiment
