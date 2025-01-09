import java.util.Arrays;

public class LargestSquareFormedInMatrix {

  int maxSum;

  public int maximalSquare(int[][] matrix) {
//    solveWithRec(0, 0, matrix);
    maxSum = 0;
//    int dp[][] = new int[matrix.length][matrix[0].length];
//    for(int i=0; i<matrix.length; i++){
//      Arrays.fill(dp[i], -1);
//    }
//    solveWithRecMemo(0, 0, matrix, dp);
    solveWithTabulation(matrix);
    return maxSum;
  }

  /*
  * With recursion
  * */
  public int solveWithRec(int i, int j, int[][] matrix){

    // base case
    if(i >= matrix.length || j >= matrix[0].length){
      return 0;
    }

    //choices
    int right = solveWithRec(i, j+1, matrix);
    int down = solveWithRec(i+1, j, matrix);
    int diagonal = solveWithRec(i+1, j+1, matrix);

    //if current cell is 1, then we can form a square
    if(matrix[i][j] == 1){
      int ans = 1 + Math.min(right, Math.min(down, diagonal));
      maxSum = Math.max(ans, maxSum);
      return ans;
    }else{
      return 0;
    }
  }

  /*
   * With recursion
   * */
  public int solveWithRecMemo(int i, int j, int[][] matrix, int dp[][]){

    // base case
    if(i >= matrix.length || j >= matrix[0].length){
      return 0;
    }

    if(dp[i][j] != -1){
      return dp[i][j];
    }

    //choices
    int right = solveWithRecMemo(i, j+1, matrix, dp);
    int down = solveWithRecMemo(i+1, j, matrix, dp);
    int diagonal = solveWithRecMemo(i+1, j+1, matrix, dp);

    //if current cell is 1, then we can form a square
    if(matrix[i][j] == 1){
      dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
      maxSum = Math.max(dp[i][j], maxSum);
      return dp[i][j];
    } else{
      dp[i][j] = 0;
      return dp[i][j];
    }
  }

  /*
  * With tabulation
  * */
  public int solveWithTabulation(int matrix[][]){
    int dp[][] = new int[matrix.length +1 ][matrix[0].length + 1];
    for(int i=matrix.length-1; i>=0; i--){
      for(int j=matrix[0].length-1; j>=0; j--){

          int right = dp[i][j+1];
          int down = dp[i+1][j];
          int diagonal = dp[i+1][j+1];

          //if current cell is 1, then we can form a square
          if(matrix[i][j] == 1){
            dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
            maxSum = Math.max(dp[i][j], maxSum);
          } else{
            dp[i][j] = 0;
          }
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    LargestSquareFormedInMatrix obj = new LargestSquareFormedInMatrix();
    int[][] matrix = new int[3][3];
    matrix[0] = new int[]{1, 1, 0};
    matrix[1] = new int[]{1, 1, 0};
    matrix[2] = new int[]{0,0, 0};
    System.out.println(obj.maximalSquare(matrix));
  }
}
