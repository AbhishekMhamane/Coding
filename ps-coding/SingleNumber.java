import java.util.Arrays;

public class SingleNumber {

  public static int singleNumber(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        i++;
      } else {
        return nums[i];
      }
    }

    return nums[nums.length - 1];
  }

  public static void main(String[] args) {
    int arr[] = { 2, 2, 1 };
    int result = singleNumber(arr);
    System.out.println("Single number: " + result);
  }
}
