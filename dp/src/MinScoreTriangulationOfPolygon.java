import java.util.Arrays;

public class MinScoreTriangulationOfPolygon {

  public int minScoreTriangulation(int[] values) {
//    int dp[][] = new int[values.length][values.length];
//    for(int i=0; i<dp.length; i++){
//      Arrays.fill(dp[i], -1);
//    }
//    return solveWithRecMemo(values,0,values.length-1, dp);
    return solveWithTabulation(values,0,values.length-1);
  }

  /*
  * With recursion
  * */
  public int solveWithRec(int values[], int start, int end) {

    // base condition
    if((start+1) == end) return 0;

    int ans = Integer.MAX_VALUE;
    // choices
    for(int k=start + 1; k<end; k++){
      int temp = (values[start] * values[k] * values[end]) + solveWithRec(values, start, k) + solveWithRec(values, k, end);
      ans = Math.min(temp, ans);
    }

    return ans;
  }

  /*
  * With memorization
  * */
  public int solveWithRecMemo(int values[], int start, int end, int dp[][]) {

    // base condition
    if((start+1) == end) return 0;

    if(dp[start][end]!=-1) return dp[start][end];

    int ans = Integer.MAX_VALUE;
    // choices
    for(int k=start + 1; k<end; k++){
      int temp = (values[start] * values[k] * values[end]) + solveWithRecMemo(values, start, k, dp) + solveWithRecMemo(values, k, end, dp);
      ans = Math.min(temp, ans);
    }

    dp[start][end] = ans;
    return dp[start][end];
  }

  /*
  * With tabulation
  * */
  public int solveWithTabulation(int values[], int start, int end) {

    int dp[][] = new int[values.length][values.length];

    for(int i = values.length-1; i>=0; i--){
      for(int j= i+2; j<values.length; j++){
        int ans = Integer.MAX_VALUE;
        // choices
        for(int k=start + 1; k<end; k++){
          int temp = (values[start] * values[k] * values[end]) + dp[i][k] + dp[k][j];
          ans = Math.min(temp, ans);
        }
        dp[i][j] = ans;
      }
    }

    return dp[0][values.length-1];
  }

  public static void main(String[] args) {
    MinScoreTriangulationOfPolygon obj = new MinScoreTriangulationOfPolygon();
    System.out.println(obj.minScoreTriangulation(new int[]{1,2,3}));
  }
}
