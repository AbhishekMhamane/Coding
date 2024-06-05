import java.util.ArrayList;
import java.util.List;

public class NDigitNumberWithIncreasingOrder {

    public static List<Integer> findNDigitNumberWithIncreasingOrder(int n) {

      ArrayList<Integer> result = new ArrayList<>();
      ArrayList<Integer> temp = new ArrayList<>();

      if(n==1){
        for(int i=0; i<=9; i++){
          result.add(i);
        }
        return result;
      }

      findNDigitNumberWithIncreasingOrderUtil(n, 1, temp, result);
      return result;
    }

    public static void findNDigitNumberWithIncreasingOrderUtil(int n, int start, ArrayList<Integer> temp, ArrayList<Integer> result) {

      // Base condition
      if(n==0){
        int ans = 0;
        for(int i=0; i<temp.size(); i++){
          ans = ans*10 + temp.get(i);
        }
        result.add(ans);
      }

      //choices
      for(int i=start; i<=9; i++){
        temp.add(i);
        findNDigitNumberWithIncreasingOrderUtil(n-1, i+1, temp, result);
        //backtrack
        temp.remove(temp.size()-1);
      }
    }

    public static void main(String[] args) {
      int n = 2;
      System.out.println(findNDigitNumberWithIncreasingOrder(n));
    }
}
