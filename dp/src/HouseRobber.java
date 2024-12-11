import java.util.Arrays;

public class HouseRobber {

  public int rob(int[] nums) {
    int dp[] = new int[nums.length];
    Arrays.fill(dp, -1);
    return solveWithRec(nums,0, dp);
  }

  public int solveWithRec(int arr[], int index, int dp[]) {

    //base condition
    if(index >= arr.length){
      return 0;
    }

    if(dp[index]!=-1) return dp[index];

    //choices
    // take curr element and go to two index next
    int include = solveWithRec(arr, index + 2, dp) + arr[index];
    // ignore curr element
    int exclude = solveWithRec(arr, index + 1, dp);

    dp[index] = Math.max(include, exclude);

    return dp[index];
  }


  public static void main(String[] args) {
    HouseRobber obj = new HouseRobber();
    int arr[] = {2,7,9,3,1};
    System.out.println(obj.rob(arr));
  }
}
