import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {

  public static int[] plusOne(int[] digits) {

    int size = digits.length;

    int last = digits[size - 1];

    int sum = last + 1;

    if (sum > 9) {
      List<Integer> arr = new ArrayList<Integer>();

      boolean addOne = true;
      int addResult = 0;

      for (int i = size - 1; i >= 0; i--) {
        if (addOne) {
          addResult = digits[i] + 1;

          if (addResult > 9) {
            arr.add(0);
            addOne = true;
          } else {
            arr.add(addResult);
            addOne = false;
          }
        } else {
          arr.add(digits[i]);
        }
      }

      if (addOne) {
        arr.add(1);
      }
      Collections.reverse(arr);

      return arr.stream().mapToInt(Integer::intValue).toArray();
    } else {
      digits[size - 1] = sum;
    }

    return digits;
  }

  public static void main(String[] args) {
    int arr[] = { 4, 3, 2, 9 };

    long startTime = System.currentTimeMillis();
    int result[] = plusOne(arr);
    long endTime = System.currentTimeMillis();

    Arrays.stream(result).forEach(i -> System.out.print(i + " "));

    System.out.println("\nTime taken : " + (endTime - startTime));
  }
}
