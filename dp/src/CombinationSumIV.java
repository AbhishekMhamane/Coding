import java.util.Arrays;

public class CombinationSumIV {

  public int combinationSum4(int nums[], int target){
    int dp[] = new int[target+1];
    Arrays.fill(dp, -1);
    return solveWithRecMemo(nums,target,dp);
  }

  /*
  * With Recursion
  * */
  public int solveWithRec(int nums[], int target){

    //base condition
    if(target == 0) return 1;
    if(target < 0) return 0;

    int sum = 0;
    //choices
    for(int i=0; i<nums.length; i++){
      sum = sum + solveWithRec(nums, target - nums[i]);
    }
    return sum;
  }

  /*
  * With Recursion and Memoization
  * */
  public int solveWithRecMemo(int nums[], int target, int dp[]){

    //base condition
    if(target == 0) return 1;
    if(target < 0) return 0;

    if(dp[target] != -1) return dp[target];

    int sum = 0;
    //choices
    for(int i=0; i<nums.length; i++){
      sum += solveWithRecMemo(nums, target - nums[i], dp);
    }

    dp[target] = sum;
    return dp[target];
  }

  /*
  * With Tabulation
  * */
  public int solveWithTabulation(int nums[], int target) {

    int dp[] = new int[target+1];

    //base case
    dp[0]=1;

    //from 1 to target
    for(int i=1; i<=target; i++){
      //choices on nums
      for(int j=0; j<nums.length; j++){
        if(i - nums[j] >= 0){
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }

  public static void main(String[] args) {
    CombinationSumIV obj = new CombinationSumIV();
    int[] nums = {1, 2};
    int target = 3;
    System.out.println(obj.combinationSum4(nums, target));
  }
}
