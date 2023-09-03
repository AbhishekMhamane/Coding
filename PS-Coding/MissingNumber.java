import java.util.Arrays;

/**
 * MissingNumber
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++)
        {
            if(i!=nums[i]) return i;
        }

        return nums[nums.length-1]+1;
    }
    public static void main(String[] args) {
        int nums[]= {0,1};
        int result = missingNumber(nums);
        System.out.println("result: " + result);
    }
}