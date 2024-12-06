import java.util.Arrays;

public class MaxSumofNonAdjEle {

  public int maxSumNonAdjEle(int arr[]) {
//    return solveWithRec(arr,0);

//    int dp[] = new int[arr.length];
//    Arrays.fill(dp, -1);
//    return solveWithRecMemo(arr, 0, dp);

    return solveWithTabulation(arr);
  }

  public int solveWithRec(int arr[], int index) {

    //base condition
    if(index >= arr.length){
      return 0;
    }

    //choices
    // take curr element and go to two index next
    int include = solveWithRec(arr, index + 2) + arr[index];
    // ignore curr element
    int exclude = solveWithRec(arr, index + 1);

    return Math.max(include, exclude);
  }

  public int solveWithRecMemo(int arr[], int index, int dp[]) {

    //base condition
    if(index >= arr.length){
      return 0;
    }

    if(dp[index] != -1) return dp[index];

    //choices
    // take curr element and go to two index next
    int include = solveWithRecMemo(arr, index + 2, dp) + arr[index];
    // ignore curr element
    int exclude = solveWithRecMemo(arr, index + 1, dp);

    dp[index] = Math.max(include, exclude);

    return dp[index];
  }

  public int solveWithTabulation(int arr[]){

    int dp[] = new int[arr.length];
    Arrays.fill(dp, 0);

    dp[0] = arr[0];

    for(int i=1; i<arr.length; i++){
      if((i-2) >= 0){
        int incl = dp[i-2] + arr[i];
        int excl = dp[i-1] + 0;
        dp[i] = Math.max(incl, excl);
      }
    }

    return dp[arr.length - 1];
  }


  public static void main(String[] args) {
    MaxSumofNonAdjEle obj = new MaxSumofNonAdjEle();
    int arr[] = {9, 9, 8, 2, 5};
    System.out.println(obj.maxSumNonAdjEle(arr));
  }
}
