import java.util.Arrays;

public class CoinChange {

  public int coinChange(int[] coins, int amount) {
//    int dp[] = new int[amount + 1];
//    Arrays.fill(dp, -1);
//    int result = solveWithRecMemo(coins, amount, dp);
//    if(result==Integer.MAX_VALUE) return -1;
//    return result;

    return solveWithTabulation(coins, amount);
  }

  /*
  * Recursive solution
  * */
  private int solveWithRec(int[] coins, int amount){
    //base cases
    if(amount == 0) return 0;
    if(amount < 0) return Integer.MAX_VALUE;

    int min = Integer.MAX_VALUE;

    // choose each coin and check the minimum number of coins required
    for(int i=0; i<coins.length; i++){
      int ans = solveWithRec(coins, amount - coins[i]);
      if(ans != Integer.MAX_VALUE) {
        // Adding ans +1 because adding current ith position ele count
        min = Math.min(ans + 1, min);
      }
    }
    return min;
  }

  /*
  * Recursive solution with memoization
  * */
  private int solveWithRecMemo(int[] coins, int amount, int dp[]){
    //base cases
    if(amount == 0) return 0;
    if(amount < 0) return Integer.MAX_VALUE;

    int min = Integer.MAX_VALUE;

    if(dp[amount] != -1) return dp[amount];

    // choose each coin and check the minimum number of coins required
    for(int i=0; i<coins.length; i++){
      int ans = solveWithRecMemo(coins, amount - coins[i], dp);
      if(ans != Integer.MAX_VALUE) {
        // Adding ans +1 because adding current ith position ele count
        min = Math.min(ans + 1, min);
      }
    }

    dp[amount] = min;

    return min;
  }

  /*
  * Tabulation solution
  * */
  private int solveWithTabulation(int[] coins, int amount){

    int dp[] = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    //base cases
    dp[0] = 0;

    for(int i= 1; i<=amount; i++){
      for(int j=0; j<coins.length; j++){
        if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }


  public static void main(String[] args) {
    int coins[] = {1, 2, 5};
    int amount = 11;
    CoinChange coinChange = new CoinChange();
    System.out.println(coinChange.coinChange(coins, amount));
  }
}
