

public class Contains_Duplicate_III {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    
        for(int i = 0; i < nums.length; i++) 
        {
            for(int j=i+1;j<=i+indexDiff;j++)
            {
                if(j<nums.length)
                {
                if((Math.abs(i-j)<=indexDiff) && (Math.abs(nums[i]-nums[j])<=valueDiff))
                {
                    return true;
                }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        int arr[] = {8,7,15,1,6,1,9,15};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1,3));

    }
}
