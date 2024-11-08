import java.util.ArrayList;
import java.util.List;

public class GrayCode {


  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < (1 << n); i++) {
      result.add(i ^ (i >> 1));
    }
    return result;
  }

  public List<Integer> grayCodeWithBacktracking(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    doBacktrack(n, result);
    return result;
  }

  public boolean doBacktrack(int n, List<Integer> result){

    if(result.size() == (1<<n)){
      int first = result.get(0);
      int last = result.get(result.size()-1);
      return Integer.bitCount(first ^ last)==1;
    }

    int last = result.get(result.size() - 1);
    for(int i=0; i<n; i++){
      int next = last ^ (1<< i);
      if(!result.contains(next)){
        result.add(next);
        if(doBacktrack(n, result)) return true;
        result.remove(result.size()-1);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    GrayCode obj = new GrayCode();
    System.out.println(obj.grayCode(2));
  }
}
