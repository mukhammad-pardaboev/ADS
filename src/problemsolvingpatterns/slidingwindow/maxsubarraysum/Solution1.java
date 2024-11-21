package problemsolvingpatterns.slidingwindow.maxsubarraysum;

public class Solution1 {
  public static Integer maxSubArraySum(int[] numbers, int num) {
    if (numbers.length == 0 || numbers.length < num) {
      return null;
    }
    int maxSum = 0;

    for (int i = 0; i <= numbers.length - num; i++) {
      int temp = 0;
      for (int j = i; j < i + num; j++) {
        temp += numbers[j];
      }
      maxSum = Math.max(maxSum, temp);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] numbers = new int[]{1,2,5,2,8,1,5};
    Integer result = maxSubArraySum(numbers, 2);
    System.out.println(result);
  }
}
