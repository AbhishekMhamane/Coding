import java.util.HashSet;

public class IntersectionOfTwoArrays {

  public static int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> result = new HashSet<>();

    for (int i = 0; i < nums1.length; i++) {
      if (!result.contains(nums1[i])) {
        for (int j = 0; j < nums2.length; j++) {
          if (nums1[i] == nums2[j]) {
            result.add(nums1[i]);
          }
        }
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int nums1[] = { 1, 2, 2, 1 };
    int nums2[] = { 2, 2 };
    int result[] = intersection(nums1, nums2);

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i] + " ");
    }
  }
}
