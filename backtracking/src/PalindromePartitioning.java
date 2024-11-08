import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  static List<List<String>> result = new ArrayList<>();


  public static List<List<String>> partition(String s) {
    List<String> list = new ArrayList<>();
    partitionHelper(s,  0, list);
    return result;
  }

  public static void partitionHelper(String s,  int index,  List<String> list){

    if(index == s.length()) {
      result.add(new ArrayList<>(list));
    }

    //find substrings
    for(int i=index; i<s.length(); i++){
      String str = s.substring(index, i+1);
      if(isPalindrome(str)) {
        list.add(str);
        partitionHelper(s, i + 1, list);
        list.remove(list.size() - 1);
      }
    }
  }

  public static boolean isPalindrome(String str){
    int start = 0;
    int end = str.length()-1;

    while(start<end){
      if(str.charAt(start) != str.charAt(end)){
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public static void main(String[] args) {
      String s = "cdd";
      System.out.println(partition(s));
  }
}
