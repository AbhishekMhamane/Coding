import java.util.*;

public class Recursion_Power_of_Three {

  public static boolean isPowerOfThree(int n) {
    return isPowerCheck(0, n);
  }

  public static boolean isPowerCheck(int power, int n) {
    double ans = Math.pow(3, power);

    if (ans == n) return true;

    if (ans > n) return false;

    return isPowerCheck(power + 1, n);
  }

  public static void main(String[] args) {
    int n = 9;
    System.out.println(isPowerOfThree(n));
  }
}
