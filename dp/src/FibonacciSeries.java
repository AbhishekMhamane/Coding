import java.util.Arrays;

public class FibonacciSeries {

  // Top down approach
  public static int fibonacciRecursion(int n) {
    int dp[] = new int[n+1];
    Arrays.fill(dp, -1);
    return fibonacciRecursionHelper(n, dp);
  }

  public static int fibonacciRecursionHelper(int n, int dp[]) {
    // base condition
    if(n <=1) return n;

    // checking if solution already exist for given n
    if(dp[n] != -1) return dp[n];

    dp[n] = fibonacciRecursionHelper(n-1, dp) + fibonacciRecursionHelper(n-2, dp);

    return dp[n];
  }

  //Bottom up approach
  public static int fibonacciTabulation(int n) {
    int dp[] = new int[n+1];

    dp[0]=0;
    dp[1]=1;

    for(int i=2; i<=n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(fibonacciTabulation(5));
  }
}
