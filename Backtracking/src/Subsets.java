import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    findSubsets(nums,0,new ArrayList<Integer>(),result);
    return result;
  }

  public void findSubsets(int nums[],int index,List<Integer> temp, List<List<Integer>> result){
    // Base condition
    if(index==nums.length){
      result.add(new ArrayList<>(temp));
      return;
    }
    // Add every subset
    result.add(new ArrayList<>(temp));
    //Choices
    for(int i=index; i<nums.length; i++){
      temp.add(nums[i]);
      findSubsets(nums, i+1 , temp, result);
      temp.remove(temp.size()-1);
    }
  }

  public static void main(String[] args) {
    Subsets subsets = new Subsets();
    int nums[] = {1,2,3};
    System.out.println(subsets.subsets(nums));
  }
}
