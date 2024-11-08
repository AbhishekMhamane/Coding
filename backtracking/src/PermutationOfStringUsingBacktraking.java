import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationOfStringUsingBacktraking {

  public static void permute(String s) {
    List<String> result = new ArrayList<>();
    permuteHelper(s,0, result);
    System.out.println(result);
  }

  public static List<String> permuteHelper(String s, int index, List<String> result){

    // base condition
    if(index == s.length()){
      // add it or print it
      result.add(s);
    }

    Set<Character> set = new HashSet<>();

    // choices
    for(int i=index; i<s.length(); i++){

      if(!set.contains(s.charAt(i))){
        set.add(s.charAt(i));
        // do swap
        s = swap(s, index, i);
        permuteHelper(s, index+1, result);
        // backtrack
        // undo the swap
        s = swap(s, index, i);
      }
    }

    return result;
  }

  public static  String swap(String s, int i, int j){
    char[] ch = s.toCharArray();
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
    return String.valueOf(ch);
  }

  public static void main(String[] args) {
    String s = "aac";
    permute(s);
  }
}
