import java.util.*;

public class Three_Sum_Closest {

  public static int threeSumCloset(int nums[], int target) {
    int result = 0, find = Integer.MAX_VALUE;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        int sum = nums[k] + nums[j] + nums[i];
        //System.out.println(sum);

        int temp = Math.abs(sum - target);
        if (find > temp) {
          find = temp;
          result = sum;
        }

        if (sum == target) {
          j++;
          k--;
        } else if (sum < target) {
          j++;
        } else if (sum > target) {
          k--;
        }
      }
    }
    return (result == Integer.MAX_VALUE) ? 0 : result;
  }

  public static void main(String args[]) {
    int nums[] = { -1, 2, 1, -4 };
    int result = threeSumCloset(nums, 1);
    System.out.println(result);
  }
}
