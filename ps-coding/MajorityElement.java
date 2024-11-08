import java.util.HashMap;
import java.util.Iterator;

public class MajorityElement {

  public static int majorityElement(int[] nums) {
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (!hashMap.containsKey(nums[i])) {
        hashMap.put(nums[i], 1);
      } else {
        hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
      }
    }

    System.out.println("HashMap " + hashMap);

    Iterator<Integer> it = hashMap.keySet().iterator();

    while (it.hasNext()) {
      int key = it.next();
      int count = hashMap.get(key);

      if (count > (nums.length / 2)) {
        return key;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    int arr[] = { 3, 1, 3 };
    int result = majorityElement(arr);
    System.out.println("result: " + result);
  }
}
