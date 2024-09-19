import java.util.ArrayList;
import java.util.List;

public class Combinations {
  public List<List<Integer>> combine(int n, int k) {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    for(int i=1; i<=n;i++){
      temp.add(i);
      combineBack(i,1,n,k,temp,result);
      temp.remove(temp.size()-1);
    }
    return result;
  }

  public void combineBack(int start, int index, int n, int k, List<Integer> temp, List<List<Integer>> res) {
    // Base condition
    if(k==index){
      res.add(new ArrayList<>(temp));
      return;
    }
    // Choices
    for(int i=start+1; i<=n; i++){
      temp.add(i);
      combineBack(i,index+1,n,k,temp,res);
      temp.remove(temp.size()-1);
    }
  }

  public static void main(String[] args) {
    int n = 4;
    int k = 2;
    Combinations obj = new Combinations();
    System.out.println(obj.combine(n, k));
  }
}
