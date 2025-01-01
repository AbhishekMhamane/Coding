import java.util.Arrays;

public class PerfectSquareProblem {

  public int minSquares(int n){
    return solveMinSquaresWithTabulation(n);
  }

  /*
  * With Recursion
  * */
  public int solveMinSquares(int n){

    // base condition
    if(n == 0 || n<0) return 0;

    int ans = Integer.MAX_VALUE;
    //choices
    for(int i=1; i*i<=n; i++){
      ans = Math.min(ans, 1 + solveMinSquares(n - i*i));
    }
    return ans;
  }

  /*
  * With memorization
  * */
  public int solveMinSquaresWithMemo(int n, int dp[]){

    // base condition
    if(n == 0 || n<0) return 0;

    if(dp[n]!=-1) return dp[n];

    int ans = Integer.MAX_VALUE;
    //choices
    for(int i=1; i*i<=n; i++){
      ans = Math.min(ans, 1 + solveMinSquaresWithMemo(n - i*i, dp));
    }
    dp[n] = ans;
    return dp[n];
  }

  /*
  * With tabulation
  * */
  public int solveMinSquaresWithTabulation(int n){

    int dp[] = new int[n+1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[0]=0;
    dp[1]=1;

    for(int i=2; i<=n; i++){
      for(int j=1; j*j<=i; j++){
        int temp = j*j;
        if(i-temp >=0){
          dp[i] = Math.min(dp[i], 1 + dp[i-temp]);
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    PerfectSquareProblem psp = new PerfectSquareProblem();
    int n = 6;
    System.out.println(psp.minSquares(n));
  }
}
