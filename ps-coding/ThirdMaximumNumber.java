import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThirdMaximumNumber {

  public static int thirdMax(int[] nums) {
    Arrays.sort(nums);
    HashSet<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    if (set.size() >= 3) {
      List<Integer> list = new ArrayList<Integer>(set);
      Collections.sort(list);
      return list.get(list.size() - 3);
    }

    return nums[nums.length - 1];
  }

  public static void main(String[] args) {
    int arr[] = { 2, 2, 3,1};
    int result = thirdMax(arr);
    System.out.println("ThirdMaximumNumber : " + result);
  }
}
