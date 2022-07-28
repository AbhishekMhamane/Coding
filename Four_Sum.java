import java.util.*;

class Four_Sum {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> resultSet = new HashSet<List<Integer>>();

    Arrays.sort(nums);

    int length = nums.length;

    for (int i = 0; i < length - 3; i++) {
      for (int j = i + 1; j < length - 2; j++) {
        int k = j + 1;
        int l = length - 1;

        while (k < l) {
          long sum = nums[l] + nums[k] + nums[j] + nums[i];
          System.out.println(sum);
          if (sum == target) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(nums[i]);
            newList.add(nums[j]);
            newList.add(nums[k]);
            newList.add(nums[l]);
            Collections.sort(newList);
            resultSet.add(newList);
            k++;
            l--;
          } else if (sum < target) {
            k++;
          } else if (sum > target) {
            l--;
          }
        }
      }
    }

    return new ArrayList<>(resultSet);
  }

  public static void main(String[] args) {
    int nums[] = { 1000000000, 1000000000, 1000000000, 1000000000 };
    int target = -294967296;
    List<List<Integer>> result = fourSum(nums, target);
    System.out.println(result);
  }
}
