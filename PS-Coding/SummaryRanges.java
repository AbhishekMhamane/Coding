import java.util.ArrayList;
import java.util.List;

/**
 * SummaryRanges
 */
public class SummaryRanges {

  public static List<String> summaryRanges(int[] nums) {
    ArrayList<String> list = new ArrayList<String>();

    for (int i = 0; i < nums.length; i++) {
      int j = i;

      while ((j != nums.length - 1) && ((nums[j] + 1) == nums[j + 1])) {
        j++;
      }

      if (i != j) list.add(nums[i] + "->" + nums[j]); else list.add(
        Integer.toString(nums[i])
      );
      i = j;
    }

    return list;
  }

  public static void main(String[] args) {
    int nums[] = { 0, 2, 3, 4, 6, 8, 9 };
    List<String> list = summaryRanges(nums);
    System.out.println(list);
  }
}
