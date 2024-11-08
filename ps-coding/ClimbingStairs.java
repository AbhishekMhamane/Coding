import java.util.Arrays;

public class ClimbingStairs {

  public static int climbStairs(int n) {
    int arr[] = new int[n + 1];
    Arrays.fill(arr, -1);
    return calculateClimbStairs(n, arr);
  }

  public static int calculateClimbStairs(int n, int arr[]) {
    if (n < 0) return 0;

    if (n == 0) {
      arr[n] = 1;
      return 1;
    }

    if (arr[n] != -1) return arr[n];

    arr[n] = calculateClimbStairs(n - 2, arr) + calculateClimbStairs(n - 1, arr);

    return arr[n];
  }

  public static void main(String[] args) {
    int n = 2;
    int result = climbStairs(n);
    System.out.println("result: " + result);
  }
}
