package problem3;

import utils.SimpleMapTests;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests of chained hash tables.
 */
public class TrieTests extends SimpleMapTests {
  /**
   * Prepare for each test.
   */
  @BeforeEach
  public void setupTrieTests() {
    stringMap = new Trie();
    runIteratorTests = false;
  } // setupTrieTests()
} // class TrieTests
