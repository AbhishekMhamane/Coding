import java.util.Arrays;

public class CutSegments {

  public int cutSegments(int n, int x, int y, int z) {
//    int dp[] = new int[n+1];
//    Arrays.fill(dp, -1);
//    int arr[] = {x,y,z};
//    int  ans = solveWithRecMemo(n, arr, dp);
//    if(ans == Integer.MIN_VALUE || ans == -1) return 0;
//    return ans;
    return solveWithTabulation(n, x, y, z);
  }

  /*
  * Solve using recursion
  * */
  private int solveWithRec(int n, int[] arr) {

    // base condition
    if(n == 0) return 0;
    if(n < 0) return Integer.MIN_VALUE;

    int ans = Integer.MIN_VALUE;

    // choices
    for(int i = 0; i < arr.length; i++) {
      ans = Math.max(ans, solveWithRec((n - arr[i]), arr) + 1);
    }

    return ans;
  }

  /*
  * Solve using recursion and memoization
  * */
  private int solveWithRecMemo(int n, int[] arr, int dp[]) {

    // base condition
    if(n == 0) return 0;
    if(n < 0) return Integer.MIN_VALUE;

    if(dp[n] != -1) return dp[n];

    // choices
    for(int i = 0; i < arr.length; i++) {
      dp[n] = Math.max(dp[n], solveWithRecMemo((n - arr[i]), arr, dp) + 1);
    }

    return dp[n];
  }

  /*
   * Solve using tabulation
   * */
  private int solveWithTabulation(int n, int x, int y, int z) {

    int dp[] = new int[n+1];
    int arr[] = {x,y,z};

    Arrays.fill(dp, Integer.MIN_VALUE);

    dp[0] = 0;

    for(int i=1; i<=n; i++){
      for(int j = 0; j < arr.length; j++) {
        if(i - arr[j] >= 0) {
          dp[i] = Math.max(dp[i], dp[i - arr[j]] + 1);
        }
      }
    }

    if(dp[n] == Integer.MIN_VALUE) return 0;
    return dp[n];
  }

  public static void main(String[] args) {
    CutSegments obj = new CutSegments();
    System.out.println(obj.cutSegments(4, 2, 1, 1));
  }
}
