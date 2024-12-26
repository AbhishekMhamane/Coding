import java.util.Arrays;

public class PaintingFenceAlgorithm {

  public int numberOfWays(int n, int k) {
//    int dp[] = new int[n + 1];
//    Arrays.fill(dp, -1);
//    return numberOfWaysWithRectMemo(n, k, dp);
    return numberOfWaysWithTabulation(n, k);
  }

  /*
  * With recursion
  * */
  public int numberOfWaysWithRect(int n, int k){

    //base case
    if(n == 1) return k;
    if(n == 2) return k + (k * (k-1));

    /*
    * Formula used
    * numberOfWays(n, k) = (numberOfWays(n-2, k) * (k-1)) + (numberOfWays(n-1, k) * (k-1))
    * Same colours used (numberOfWays(n-2, k) * (k-1))
    * Different colours used (numberOfWays(n-1, k) * (k-1))
    * */

    return (numberOfWaysWithRect(n-2,k) * (k-1))
            + (numberOfWaysWithRect(n-1,k) * (k-1));
  }

  /*
  * With memoization
  * */
  public int numberOfWaysWithRectMemo(int n, int k, int dp[]){

    //base case
    if(n == 1) return k;
    if(n == 2) return k + (k * (k-1));

    if(dp[n] != -1) return dp[n];

    dp[n] = (numberOfWaysWithRectMemo(n-2,k,dp) * (k-1))
                          + (numberOfWaysWithRectMemo(n-1,k,dp) * (k-1));

    return dp[n];
  }


  /*
   * With memoization
   * */
  public int numberOfWaysWithTabulation(int n, int k){

    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);

    //base case
    dp[1] = k;
    dp[2] = k + (k * (k-1));

    for(int i=3; i<=n; i++){
      dp[i] = (dp[i-2] * (k-1)) + (dp[i-1] * (k-1));
    }
    return dp[n];
  }

  public static void main(String[] args) {
    PaintingFenceAlgorithm obj = new PaintingFenceAlgorithm();
    int n = 4;
    int k = 3;
    System.out.println(obj.numberOfWays(n, k));
  }
}
