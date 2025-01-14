import java.util.Arrays;

public class MinimumSidewayJumps {

  public int minSideJumps(int[] obstacles) {
    /*return solveWithRec(obstacles,0,2);*/
    int dp[][] = new int[4][obstacles.length];
    for(int i=0; i< dp.length; i++){
      Arrays.fill(dp[i], -1);
    }
    return solveWithRecMemo(obstacles, 0, 2, dp);
  }


  /*
  * With recursion
  * */
  public int solveWithRec(int[] obstacles, int index, int currLane){

    // base condition
    if(index == obstacles.length-1) return 0;

    int ans = Integer.MAX_VALUE;
    //choices
    //forward
    if(obstacles[index + 1] != currLane){
      ans = solveWithRec(obstacles, index+1, currLane);
    }else{
      //sideways
      for(int i=1; i<=3; i++){
        if(i!=currLane && obstacles[index]!=i){
          ans = Math.min(ans, solveWithRec(obstacles, index+1, i) +1);
        }
      }
    }
    return ans;
  }

  /*
  * With recursion memorization
  * */
  public int solveWithRecMemo(int[] obstacles, int index, int currLane, int dp[][]){

    // base condition
    if(index == obstacles.length-1) return 0;

    if(dp[currLane][index] != -1) return dp[currLane][index];

    int ans = Integer.MAX_VALUE;
    //choices
    if(obstacles[index + 1] != currLane){
      ans = solveWithRecMemo(obstacles, index+1, currLane, dp);
    }else{
      for(int i=1; i<=3; i++){
        if(i!=currLane && obstacles[index]!=i){
          ans = Math.min(ans, solveWithRecMemo(obstacles, index+1, i, dp) +1);
        }
      }
    }
    dp[currLane][index] = ans;
    return dp[currLane][index];
  }

  public static void main(String[] args) {
    MinimumSidewayJumps obj = new MinimumSidewayJumps();
    int obstacle[] = new int[]{0,1,2,3,0};
    System.out.println(obj.minSideJumps(obstacle));
  }
}
