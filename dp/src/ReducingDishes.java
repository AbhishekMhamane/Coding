import java.util.Arrays;

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {
      int dp[][] = new int[satisfaction.length + 1][satisfaction.length + 1];
      for(int i=0; i<satisfaction.length; i++) {
        Arrays.fill(dp[i], -1);
      }
      Arrays.sort(satisfaction);
  //    return solveWithRec(0, satisfaction, 1);
      return solveWithRecMemo(0, satisfaction, 1, dp);
    }

    /*
    * With Recursion
    * */
    public int solveWithRec(int index, int[] satisfaction, int time) {
      //base condition
      if(index == satisfaction.length) return 0;
      // choices
      // include
      int include = satisfaction[index] * time + solveWithRec(index+1, satisfaction, time+1);
      // exclude
      int exclude = solveWithRec(index+1, satisfaction, time);

      return Math.max(include, exclude);
    }

    /*
    * With Recursion and Memoization
    * */
    public int solveWithRecMemo(int index, int[] satisfaction, int time, int dp[][]) {
      //base condition
      if(index == satisfaction.length) return 0;

      if(dp[index][time] != -1) return dp[index][time];
      // choices
      // include
      int include = satisfaction[index] * time + solveWithRecMemo(index+1, satisfaction, time+1, dp);
      // exclude
      int exclude = solveWithRecMemo(index+1, satisfaction, time, dp);

      dp[index][time] = Math.max(include, exclude);
      return dp[index][time];
    }

  public static void main(String[] args) {
    ReducingDishes rd = new ReducingDishes();
    int[] satisfaction = {4,3,2};
    System.out.println(rd.maxSatisfaction(satisfaction));
  }
}
