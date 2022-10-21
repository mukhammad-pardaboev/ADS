package bigo;

/*
 * Write a function called sumZero which accepts a sorted array of integers.
 * The function should find the first pair where the sum is 0.Return any array that includes both
 * values that sum to zero or undefined if a pair does not exist
*/

class AddUpTo {
  public static void main(String[] args) throws Exception {
    AddUpTo addUpTo = new AddUpTo();
    // int result = addUpTo.addUpTo2(6);

    // System.out.println(result);

    addUpToTiming(addUpTo, 1000000000, 2);
  }

  private static void addUpToTiming(
    AddUpTo addUpTo,
    int number,
    int methodNum
  ) {
    long start;
    long end;
    long elapsed;

    if (methodNum == 1) {
      start = System.nanoTime();
      addUpTo.addUpTo1(number);
      end = System.nanoTime();
    } else {
      start = System.nanoTime();
      addUpTo.addUpTo2(number);
      end = System.nanoTime();
    }

    elapsed = end - start;
    double elapsedTimeInSecond = (double) elapsed / 1_000_000_000;
    
    System.out.println("Time Elapsed for addUpTo" + methodNum + ": " + elapsedTimeInSecond + " seconds");
  }

  public int addUpTo1(int n) {
    int total = 0;
    for (int i = 1; i <= n; i++) {
      total += i;
    }
    return total;
  }

  public int addUpTo2(int n) {
    return n * (n + 1) / 2;
  }
}