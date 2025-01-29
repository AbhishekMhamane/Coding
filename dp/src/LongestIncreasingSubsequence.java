import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] nums) {
    int dp[][] = new int[nums.length + 1][nums.length + 1];
    for(int i=0; i<nums.length; i++){
      Arrays.fill(dp[i], -1);
    }
    return solveWithRecMemo(0, -1, nums, dp);
  }

  public int solveWithRec(int curr, int prev, int nums[] ){

    //base condition
    if(curr >= nums.length) return 0;

    // choices
    int takeCount = 0;
    // include
    if(prev == -1 || nums[prev] < nums[curr]){
      takeCount = 1 + solveWithRec(curr + 1, curr, nums);
    }
    //exclude
    int notTake = 0 + solveWithRec(curr + 1, prev, nums);

    return Math.max(takeCount, notTake);
  }

  public int solveWithRecMemo(int curr, int prev, int nums[], int dp[][]){

    //base condition
    if(curr >= nums.length) return 0;

    if(dp[curr][prev + 1] != -1) return dp[curr][prev + 1];

    // choices
    int takeCount = 0;
    // include
    if(prev == -1 || nums[prev] < nums[curr]){
      takeCount = 1 + solveWithRecMemo(curr + 1, curr, nums, dp);
    }
    //exclude
    int notTake = 0 + solveWithRecMemo(curr + 1, prev, nums, dp);

    dp[curr][prev + 1] = Math.max(takeCount, notTake);
    return dp[curr][prev + 1];
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    int nums[] = {3, 10, 2, 1, 20};
    System.out.println(lis.lengthOfLIS(nums));
  }
}
