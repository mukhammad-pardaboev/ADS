package bigo;

/**
 * Suppose we want to write a function that calculates the sum of all numbers
 * from 1 up to (and including) some number n.
 */
class AddUpTo2Timing {
  public static void main(String[] args) {

    long number = 1000000000;
    long start;
    long end;
    long elapsed;

    start = System.nanoTime();
    addUpTo(number);
    end = System.nanoTime();

    elapsed = end - start;
    double elapsedTimeInSecond = (double) elapsed / 1_000_000_000;

    System.out.println("Time Elapsed for addUpTo" + ": " + elapsedTimeInSecond + " seconds");
  }

  public static long addUpTo(long n) {
    return n * (n + 1) / 2;
  }
}