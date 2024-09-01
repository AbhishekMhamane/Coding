import java.util.*;

public class Recursion_Decode_String {

  public static String decodeString(Stack<String> stack, String s, int i) {
    String result = "";

    if (i == s.length()) {
      Iterator value = stack.iterator();
      while (value.hasNext()) {
        result = result + value.next();
      }
      return result;
    }

    if (s.charAt(i) == '[' || Character.isAlphabetic(s.charAt(i))) {
      stack.push(Character.toString(s.charAt(i)));
      result = decodeString(stack, s, i + 1);
    } else if (Character.isDigit(s.charAt(i))) {
      String sDigit = "";
      int j = i;
      while (Character.isDigit(s.charAt(j)) && j < s.length()) {
        sDigit = sDigit + Character.toString(s.charAt(j));
        j++;
      }
      i = j - 1;
      stack.push(sDigit);

      result = decodeString(stack, s, i + 1);
    } else {
      String temp = "";

      while (!stack.peek().equals("[")) {
        String tt = stack.pop();
        temp = tt + temp;
      }

      stack.pop();

      if (Character.isDigit(stack.peek().charAt(0))) {
        int j = Integer.parseInt(stack.pop());

        String newSt = "";
        for (int k = 0; k < j; k++) {
          newSt = newSt + temp;
        }

        temp = newSt;
      }

      stack.push(temp);

      result = decodeString(stack, s, i + 1);
    }

    return result;
  }

  public static void main(String[] args) {
    String s = "2[ab2[cd]]";
    Stack<String> stack = new Stack<String>();
    String result = decodeString(stack, s, 0);
    System.out.println(result);
  }
}
