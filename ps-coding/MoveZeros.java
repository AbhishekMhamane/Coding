import java.util.ArrayList;

public class MoveZeros {

  public static void moveZeroes(int[] nums) {
    ArrayList<Integer> zeroes = new ArrayList<Integer>();

    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 0) {
        zeroes.add(nums[i]);
      } else {
        zeroes.add(0, nums[i]);
      }
    }

    int i = 0;

    for (int ele : zeroes) {
      nums[i] = ele;
      i++;
    }
  }

  private static void printArray(int[] nums) {
    for (int i : nums) {
      System.out.print(i + " ");
    }
  }

  public static void main(String[] args) {
    int nums[] = { 0, 1, 0, 3, 12 };
    moveZeroes(nums);
    printArray(nums);
  }
}
