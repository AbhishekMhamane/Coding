import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * FindDisappearedNumbers
 */
public class FindDisappearedNumbers {

  public static List<Integer> findDisappearedNumbers(int[] nums) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    HashSet<Integer> set = new HashSet<Integer>();

    for (int i : nums) {
      set.add(i);
    }

    for (int j = 1; j <= nums.length; j++) {
      if (!set.contains(j)) {
        numbers.add(j);
      }
    }

    return numbers;
  }

  public static void main(String[] args) {
    int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1, 10 };
    List<Integer> numbers = findDisappearedNumbers(arr);
    System.out.println("results: " + numbers);
  }
}
