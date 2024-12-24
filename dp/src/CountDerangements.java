import java.util.Arrays;

public class CountDerangements {

  public int disarrange(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    return disarrangeWithMemo(n, dp);
  }

  /*
  * With recursion
  * */
  public int disarrangeRec(int n){
    //base condition
    if(n == 1) return 0;

    if( n == 2) return 1;

    return (n-1) * (disarrangeRec(n-2) + disarrangeRec(n-1));
  }

  /*
  * With memoization
  * */
  public int disarrangeWithMemo(int n, int dp[]) {

    //base condition
    if(n == 1) return 0;

    if( n == 2) return 1;

    if(dp[n] != -1) return dp[n];

    dp[n] = (n-1) * (disarrange(n-2) + disarrange(n-1));

    return dp[n];
  }

  /*
  * With tabulation
  * */
  public int disarrangeWithTabulation(int n){
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);

    //base condition
    dp[1]=0;
    dp[2]=1;

    for(int i = 3; i<=n; i++){
      dp[i] = (i-1) * (dp[i-2] + dp[i-1]);
    }

    return dp[n];
  }

  public static void main(String[] args) {
    CountDerangements obj = new CountDerangements();
    int n = 4;
    System.out.println(obj.disarrangeWithTabulation(n));
  }
}
