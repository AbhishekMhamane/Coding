public class Remove_Element {

  public static int removeElement(int[] nums, int val) {
    int tempArr[] = new int[nums.length];
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        tempArr[j] = nums[i];
        nums[j] = tempArr[j];
        j++;
      }
    }

    return j;
  }

  public static void main(String[] args) {
    int nums[] = { 3, 2, 2, 3 };
    int val = 3;
    int result = removeElement(nums, val);
    System.out.println(result);
  }
}
