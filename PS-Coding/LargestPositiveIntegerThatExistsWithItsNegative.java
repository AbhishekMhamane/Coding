import java.util.ArrayList;
import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

  public static int findMaxK(int[] nums) {

    ArrayList<Integer> list = new ArrayList<Integer>();
    int max = -1;

    // Sort the array
    Arrays.sort(nums);

    for(int i=0;i<nums.length;i++) {
      if(nums[i] < 0){
        list.add(nums[i]);
      }else{
        if(list.contains(-nums[i])){
          max = Math.max(max, nums[i]);
        }
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int inputs[] = {-1,10,6,7,-7,1};
    int result = findMaxK(inputs);
    System.out.println("Result: " + result);
  }

}
