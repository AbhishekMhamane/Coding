import java.util.*;

public class CombinationSum_III {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    combinationSumHelper(1, k, n, new ArrayList<Integer>(), result);
    return result;
  }

  public void combinationSumHelper(int index, int k, int n, List<Integer> temp, List<List<Integer>> result){
    //base condition
    if(n == 0 && temp.size() == k){
      result.add(new ArrayList<>(temp));
      return;
    }

    if(temp.size() > k)  return;

    //choices
    for(int i=index; i<=9; i++){
      if(i > n) break;
        temp.add(i);
        combinationSumHelper(i+1, k, n-i, temp, result);
        temp.remove(temp.size()-1);
    }
  }

  public void combinationSumHelper2(int index, int k, int n, int sum, List<Integer> temp, List<List<Integer>> result){
    //base condition
    if(index > k){
      System.out.println(temp);
      if(sum == n){
        List<Integer> demoList = new ArrayList<>(temp);
        Collections.sort(demoList);
        if(!result.contains(demoList))  result.add(demoList);
      }
      return;
    }

    //choices
    for(int i=index; i<=9; i++){
      if(!temp.contains(i) && (sum + i) <= n){
        sum = sum + i;
        temp.add(i);
        combinationSumHelper2(index+1, k, n, sum, temp, result);
        temp.remove(temp.size()-1);
        sum = sum - i;
      }
    }
  }


  public static void main(String[] args) {
    CombinationSum_III sum = new CombinationSum_III();
    int k=3, n=15;
    System.out.println(sum.combinationSum3(k,n));
  }
}
