import java.util.ArrayList;
import java.util.List;

public class SubsetSumProblem {

  public List<List<Integer>> findSubsetSum(int set[], int sum){
    List<List<Integer>> result = new ArrayList<>();
    help(0, 0, sum, set, new ArrayList<Integer>(), result);
    return result;
  }

  public void help(int index, int tempSum, int sum, int set[], List<Integer> temp, List<List<Integer>> result){

    // bc
    if(tempSum == sum){
      result.add(new ArrayList<>(temp));
    }
    if(index == set.length) {
      return;
    }

    //choices
    for(int i = index; i<set.length; i++){
      if((tempSum + set[i]) <= sum){
        temp.add(set[i]);
        help(i + 1, tempSum + set[i], sum, set, temp, result);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    SubsetSumProblem obj = new SubsetSumProblem();
    int set[] = {1,2,1};
    int sum = 3;
    System.out.println(obj.findSubsetSum(set,sum));
  }
}
