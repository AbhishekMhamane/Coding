import java.util.Arrays;

public class FindtheMaximumSumofNodeValues {

  public static long maximumValueSum(int[] nums, int k, int[][] edges) {

    long result = 0;

//    int count = 0;
//    int min = Integer.MAX_VALUE;
//
//    for(int i=0; i<nums.length; i++){
//
//      if((nums[i] ^ k) > nums[i]){
//        result = result + (nums[i] ^ k);
//        count = count +1;
//        min = Math.min(min, (nums[i] ^ k) - nums[i]);
//      }else{
//        result = result + nums[i];
//        min = Math.min(min, nums[i] - (nums[i] ^ k));
//      }
//    }
//
//    if(count % 2 != 0){
//      result = result - min;
//    }

    for(int i=0; i<edges.length; i++){
      nums[i] = (nums[i] ^ k);
      System.out.print(nums[i]+" ");
    }

    return result;
  }

  public static void main(String[] args) {

//    int[] nums = {1, 2, 1};
    int[] nums = {24,78,1,97,44};

    int k = 6;

//    int[][] edges = {{0, 1}, {0,2}};
//    int[][] edges = {{0, 1}, {0,2},{0,3}, {0,4}, {0,5}};
    int[][] edges = {{0,2}, {1,2},{4,2},{3,4}};
    System.out.println(maximumValueSum(nums, k, edges));
  }

}
