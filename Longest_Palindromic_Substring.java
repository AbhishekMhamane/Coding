import java.util.*;

public class Longest_Palindromic_Substring {

  public static String Longest_String(String input) {
    String longest = "";

    for (int i = 0; i < input.length(); i++) {
      for (int j = input.length() - 1; j > i; j--) {
        String subTemp = input.substring(i, j + 1);
        if (subTemp.length() > longest.length() && is_Palindrome(subTemp)) {
          longest = subTemp;
          break;
        }
      }
    }
    return (longest.length()>0)?longest:input.charAt(0)+"";
  }

  public static boolean is_Palindrome(String subTemp) {
    int i = 0, j = subTemp.length() - 1;

    while (i < j) {
      if (subTemp.charAt(i) != subTemp.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  public static void main(String args[]) {
    System.out.println("Hi Abhishek !");
    System.out.println("Programe is designed to find out longest palindromic substring");
    String input = "babad";
    System.out.println("input string is : " + input);
    String result = Longest_String(input);
    System.out.println(result);
  }
}
