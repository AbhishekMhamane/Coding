import java.util.*;

public class ZigZag_Conversion {

  public static String convert_ZigZag(String s, int rows) {
    String arr[] = new String[rows];
    Arrays.fill(arr, "");
    String result = "";
    boolean inc = false, dec = false;
    int j = 0;

    for (int i = 0; i < s.length(); i++) {
      arr[j] += s.charAt(i);

      if (j == 0) {
        inc = true;
        dec = false;
      }

      if (j == rows - 1) {
        inc = false;
        dec = true;
      }

      if (inc) j++;
      if (dec) j--;
    }

    for (int i = 0; i < arr.length; i++) {
      result += arr[i];
    }

    return result;
  }

  public static void main(String args[]) {
    String input = "PAYPALISHIRING";
    int rows = 3;
    System.out.println("Input String : "+input);
    System.out.println("No of rows : "+rows);
    String result = convert_ZigZag(input, rows);
    System.out.println("ZigZag string is : " + result);
  }
}
