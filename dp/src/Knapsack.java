import java.util.Arrays;

public class Knapsack {

  public int knapSack(int W, int wt[], int val[], int n){
    int dp[][] = new int[n][W+1];
    for(int i=0; i<n; i++){
      Arrays.fill(dp[i], -1);
    }
    return solveKnapsackFromNMemo(n-1, W, wt, val, dp);
  }

  /*
  * With recursion goes from n to 0
  * */
  public int solveKnapsackFromN(int index, int W, int wt[], int val[]) {
    // Base condition
    if(index == 0){
      if(wt[index] <= W)
        return val[index];
      else
        return 0;
    }

    int include = 0;
    // include
    if(wt[index] <= W)
      include = solveKnapsackFromN(index - 1, W - wt[index], wt, val) + val[index];
    // exlude
    int exclude = solveKnapsackFromN(index - 1, W, wt, val);

    return Math.max(include, exclude);
  }

  /*
   * With recursion with memo goes from n to 0
   * */
  public int solveKnapsackFromNMemo(int index, int W, int wt[], int val[], int dp[][]) {
    // Base condition
    if(index == 0){
      if(wt[index] <= W)
        return val[index];
      else
        return 0;
    }

    if(dp[index][W] != -1) return dp[index][W];

    int include = 0;
    // include
    if(wt[index] <= W)
      include = solveKnapsackFromNMemo(index - 1, W - wt[index], wt, val,dp) + val[index];
    // exlude
    int exclude = solveKnapsackFromNMemo(index - 1, W, wt, val,dp);

    dp[index][W] = Math.max(include, exclude);

    return dp[index][W];
  }

  /*
  * With recursion goes from 0 to n
  * */
  public int solveKnapsack(int index, int W, int wt[], int val[], int n) {

    // Base condition
    if(index == n || W == 0){
      return 0;
    }

    // if weight of the nth item is more than the Knapsack capacity
    if(wt[index] > W)
      return solveKnapsack(index + 1, W, wt, val, n);

    // include
    int inc = solveKnapsack(index + 1, W - wt[index], wt, val, n) + val[index];
    // exlude
    int exc = solveKnapsack(index + 1, W, wt, val, n);

    return Math.max(inc, exc);
  }

  /*
  * With memoization goes from 0 to n
  * */
  public int solveKnapsackWithMemo(int index, int W, int wt[], int val[], int n, int dp[][]) {

    // Base condition
    if(index == n || W == 0){
      return 0;
    }

    if(dp[index][W] != -1) return dp[index][W];

    // if weight of the nth item is more than the Knapsack capacity
    if(wt[index] > W){
      dp[index][W] = solveKnapsackWithMemo(index + 1, W, wt, val, n, dp);
    }
    else{
      dp[index][W] =  Math.max(solveKnapsackWithMemo(index + 1, W - wt[index], wt, val, n, dp) + val[index]
              , solveKnapsackWithMemo(index + 1, W, wt, val, n, dp));
    }
    return dp[index][W];
  }


  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int profit[] = new int[] { 60, 100, 120 };
    int weight[] = new int[] { 10, 20, 30 };
    int W = 50;
    int n = profit.length;
    System.out.println(ks.knapSack(W, weight, profit, n));
  }
}
