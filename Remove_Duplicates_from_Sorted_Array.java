import java.util.*;

public class Remove_Duplicates_from_Sorted_Array {

  public static int removeDuplicates(int[] nums) {
    int arrLength = 0, i = 0, j = 0;

    while (i < nums.length - 1) {
      if (nums[i] != nums[i + 1]) {
        nums[j] = nums[i];
        j++;
        arrLength++;
      }
      i++;
    }

    nums[j] = nums[i];
    arrLength++;

    return arrLength;
  }

  public static void main(String args[]) {
    int nums[] = { 1, 2, 2, 3, 4, 4, 4 };
    int accurateLength = removeDuplicates(nums);
    System.out.println(accurateLength);
  }
}
