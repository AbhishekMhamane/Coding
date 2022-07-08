import java.util.*;

class LogestSubString {

  public static int findLongestSubString(String s) {
    int longestString = 0;
    Queue<Character> queue = new LinkedList<Character>();

    for (char element : s.toCharArray()) {
      while (queue.contains(element)) {
        queue.remove();
      }
      queue.add(element);

      if (longestString < queue.size()) {
        longestString = queue.size();
      }
    }
    return longestString;
  }

  public static void main(String args[]) {
    String s = "";

    int result = findLongestSubString(s);

    System.out.println(result);
  }
}
