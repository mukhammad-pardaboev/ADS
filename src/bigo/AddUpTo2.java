package bigo;

/**
 * Suppose we want to write a function that calculates the sum of all numbers
 * from 1 up to (and including) some number n.
 */
class AddUpTo2 {
  public static void main(String[] args) {

    long number = 6;

    long total = addUpTo(number);
    System.out.println("Total: " + total);
  }

  /**
   * Second: math approach using formula O(1) complexity
   * @param n
   * @return
   */
  public static long addUpTo(long n) {
    return n * (n + 1) / 2;
  }
}