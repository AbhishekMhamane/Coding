import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Contains_Duplicate_II
 */
public class Contains_Duplicate_II {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();

        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                ArrayList<Integer> indexList = map.get(nums[i]);

                for(Integer j : indexList)
                {
                    if(Math.abs(j-i) <= k)
                    {
                        return true;
                    }
                }
                indexList.add(i);
                map.put(nums[i], indexList);
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i],list);
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(arr, 2));
    }
}