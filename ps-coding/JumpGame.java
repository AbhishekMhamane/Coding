import java.util.Arrays;

public class JumpGame {

  public static boolean canJump(int[] nums) {
    return checkCanJump(nums, 0, new Boolean[nums.length + 1]);
  }

  public static boolean checkCanJump(int[] nums, int index, Boolean[] memo) {
    if (index > nums.length) return false;

    if (index == nums.length - 1) {
      return true;
    }

    if (memo[index] != null) {
      return memo[index];
    }

    for (int i = 1; i <= nums[index]; i++) {
      if (checkCanJump(nums, index + i, memo)) {
        memo[index] = true;
        return true;
      }
    }

    memo[index] = false;
    return false;
  }

  public static final void main(String[] args) {
    int arr[] = { 0, 2, 1, 0, 4 };
    System.out.println(canJump(arr));
  }
}
