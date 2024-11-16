import java.util.Arrays;

public class MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] cost) {
    int dp[] = new int[cost.length];
    Arrays.fill(dp, -1);
//    return Math.min(solve(cost,  0, dp), solve(cost,  1, dp));
    return solve(cost);
  }

  // Top down approach (Recursion with Memo)
  public int solve(int[] cost, int i, int dp[]){

    // base cases
    if(i==cost.length-1) return cost[cost.length-1];
    if(i==cost.length-2) return cost[cost.length-2];

    if(dp[i] != -1) return dp[i];

    dp[i] = cost[i] + Math.min(solve(cost,  i+1, dp), solve(cost,  i+2, dp));

    return dp[i];
  }

  // Bottom up approach (Tabulation)
  public int solve(int[] cost){
    int dp[] = new int[cost.length];
    Arrays.fill(dp, -1);

    // base cases
    dp[0] = cost[0];
    dp[1] = cost[1];

    for(int i=2; i<cost.length; i++){
      dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    }

    return Math.min(dp[cost.length-1], dp[cost.length-2]);
  }

  public static void main(String[] args) {
    int cost[] = {1,100,1,1,1,100,1,1,100,1};
    MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
    System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
  }
}
