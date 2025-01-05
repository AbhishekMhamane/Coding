import java.util.Arrays;

public class MinimumCostForTickets {

  public int mincostTickets(int[] days, int[] costs) {
    return solveWithTabulation(0, days, costs);
  }

  /*
  * With recursion
  * */
  public int solveWithRec(int index, int days[], int costs[]){

    // base condition
    if(index >= days.length) return 0;

    // choices
    //1 day pass
    int oneDay = costs[0] +  solveWithRec(index + 1, days, costs);

    //7 days pass
    int i;
    for(i=index; i<days.length && days[i]<days[index]+7; i++);
    int seventDay = costs[1] + solveWithRec(i, days, costs);

    //30 days pass
    for(i=index; i<days.length && days[i]<days[index]+30; i++);
    int thirtyDay = costs[2] + solveWithRec(i, days, costs);

    return Math.min(oneDay, Math.min(seventDay, thirtyDay));
  }

  /*
  * With recursion and memoization
  * */
  public int solveWithRecMemo(int index, int days[], int costs[], int dp[]){

    // base condition
    if(index >= days.length) return 0;

    if(dp[index]!=-1) return dp[index];

    // choices
    //1 day pass
    int oneDay = costs[0] +  solveWithRecMemo(index + 1, days, costs, dp);

    //7 days pass
    int i;
    for(i=index; i<days.length && days[i]<days[index]+7; i++);
    int seventDay = costs[1] + solveWithRecMemo(i, days, costs, dp);

    //30 days pass
    for(i=index; i<days.length && days[i]<days[index]+30; i++);
    int thirtyDay = costs[2] + solveWithRecMemo(i, days, costs, dp);

    dp[index] = Math.min(oneDay, Math.min(seventDay, thirtyDay));
    return dp[index];
  }

  public int solveWithTabulation(int index, int days[], int costs[]){

    int dp[] = new int[days.length + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[days.length] = 0;

    for(int k=days.length-1; k>=0; k--){
      int oneDay = costs[0] +  dp[k+1];

      //7 days pass
      int i;
      for(i=k; i<days.length && days[i]<days[k]+7; i++);
      int seventDay = costs[1] + dp[i];

      //30 days pass
      for(i=k; i<days.length && days[i]<days[k]+30; i++);
      int thirtyDay = costs[2] + dp[i];

      dp[k] = Math.min(oneDay, Math.min(seventDay, thirtyDay));
    }

    return dp[0];
  }

  public static void main(String[] args) {
    MinimumCostForTickets obj = new MinimumCostForTickets();
    int days[] = {1,4,6,7,8,20};
    int costs[] = {2,7,15};
    System.out.println(obj.mincostTickets(days, costs));
  }
}
