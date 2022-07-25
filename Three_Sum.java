import java.util.*;

public class Three_Sum {

  public static List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> result = new HashSet<List<Integer>>();
    int numsLength = nums.length;
    Arrays.sort(nums);

    for (int low = 0; low < numsLength - 2; low++) {
      int mid = low + 1;
      int high = numsLength - 1;

      while (mid < high) {
        int sum = nums[low] + nums[mid] + nums[high];

        if (sum == 0) {
          List<Integer> newList = new ArrayList<Integer>();
          newList.add(nums[low]);
          newList.add(nums[mid]);
          newList.add(nums[high]);
          Collections.sort(newList);
          result.add(newList);
          mid++;
          high--;
        } else if (sum > 0) {
          high--;
        } else if (sum < 0) {
          mid++;
        }
      }
    }
    return new ArrayList<>(result);
  }

  public static void main(String[] args) {
    int nums[] = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }
}
