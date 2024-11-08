import java.util.*;

public class SumofAllSubsetXORTotals {

  public int subsetXORSum(int[] nums) {
    List<Integer> subset = new ArrayList<>();
    return walkSubset(0, nums, subset,0);
  }

  public int walkSubset(int index, int nums[], List<Integer> subset, int  result ){
    // Base condition
    if(index == nums.length){
        return result;
    }
    //choices
    for(int i=index; i<nums.length; i++){
      subset.add(nums[i]);
      int xorResult = calculateXOR(subset);
      result = walkSubset(i+1, nums, subset, result + xorResult);
      subset.remove(subset.size()-1);
    }
    return result;
  }

  public int calculateXOR(List<Integer> subset) {
    int xorResult = 0;
    for (int num : subset) {
      xorResult ^= num;
    }
    return xorResult;
  }

  public static void main(String[] args) {
    SumofAllSubsetXORTotals sumofAllSubsetXORTotals = new SumofAllSubsetXORTotals();
    int[] nums = {3,4,5,6,7,8};
    System.out.println(sumofAllSubsetXORTotals.subsetXORSum(nums));
  }
}
