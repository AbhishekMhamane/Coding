import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * MergeSortedArray
 */
public class MergeSortedArray {

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int arr[] = new int[nums1.length];

    for (int i = 0; i < m; i++) {
      arr[i] = nums1[i];
    }

    int index = m;

    for (int j = 0; j < n; j++) {
      arr[index] = nums2[j];
      index = index + 1;
    }

    Arrays.sort(arr);

    for (int i = 0; i < m + n; i++) {
      nums1[i] = arr[i];
    }
  }

  public static void mergeUsingStreams(int[] nums1, int m, int[] nums2, int n) {
    int arr[] = new int[nums1.length];

    IntStream
      .range(0, m)
      .forEach(i -> {
        arr[i] = nums1[i];
      });

    IntStream
      .range(0, n)
      .forEach(i -> {
        arr[m + i] = nums2[i];
      });

    IntStream.of(arr).forEach(System.out::print);

    Arrays.sort(arr);

    IntStream
      .range(0, m + n)
      .forEach(i -> {
        nums1[i] = arr[i];
      });
  }

  public static void main(String[] args) {
    int nums1[] = { -1, 0, 0, 3, 3, 3, 0, 0, 0 };
    int nums2[] = { 1, 2, 2 };
    int m = 6, n = 3;

    merge(nums1, m, nums2, n);

    System.out.print("Result nums1 array : ");
    IntStream.of(nums1).forEach(System.out::print);
  }
}
