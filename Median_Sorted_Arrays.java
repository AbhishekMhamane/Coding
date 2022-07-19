public class Median_Sorted_Arrays {

  public static void main(String args[]) {
    int nums1[] = { 1, 2 };
    int nums2[] = { 3, 4 };

    int n = nums1.length + nums2.length;
    int num[] = new int[n];

    for (int i = 0; i < nums1.length; i++) {
      num[i] = nums1[i];
    }

    int i = nums1.length;
    for (int j = 0; j < nums2.length; j++) {
      num[i] = nums2[j];
      i++;
    }

    for (i = 0; i < num.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < num.length; j++) {
        if (num[j] < num[index]) {
          index = j;
        }
      }
      int smallerNumber = num[index];
      num[index] = num[i];
      num[i] = smallerNumber;
    }

    int l = num.length;

    if (l % 2 == 0) {
      int r = l / 2;
      float result = num[r--] + num[r];
      double rt = result / 2;
      System.out.println("Median is : " + rt);
    } else {
      int r = (int) l / 2;
      double rt = num[r];
      System.out.println("Median is : " + rt);
    }
  }
}
