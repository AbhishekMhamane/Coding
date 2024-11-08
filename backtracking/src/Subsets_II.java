import java.util.*;

public class Subsets_II {

  public List<List<Integer>>  subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    findOutSubsetsWithDup(0, nums, new ArrayList<Integer>(),  result);
    return result;
  }

  public void findOutSubsetsWithDup(int index, int nums[], List<Integer> temp,List<List<Integer>> result){
    // base condition
    if(index == nums.length){
      result.add(new ArrayList<>(temp));
      return;
    }
    // add current subset as well
    result.add(new ArrayList<>(temp));
    // find other choices
    for(int i=index; i<nums.length; i++){
      if (i > index && nums[i] == nums[i - 1])  continue; // Skip duplicates
      temp.add(nums[i]);
      findOutSubsetsWithDup(i+1, nums, temp,result);
      temp.remove(temp.size()-1);
    }
  }

  public static void main(String[] args) {
    Subsets_II subsets = new Subsets_II();
    int nums[] = {1,2,2};
    System.out.println(subsets.subsetsWithDup(nums));
  }
}
