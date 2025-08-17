package bigo;

/**
 * Suppose we want to write a function that calculates the sum of all numbers
 * from 1 up to (and including) some number n.
 */
class AddUpTo1 {
  public static void main(String[] args) {

    long number = 3;

    long total = addUpTo(number);
    System.out.println("Total: " + total);
  }

  /**
   * First: naive approach O(n) complexity
   * @param n
   * @return
   */
  public static long addUpTo(long n) {
    long total = 0;
    for (int i = 1; i <= n; i++) {
      total += i;
    }
    return total;
  }
}