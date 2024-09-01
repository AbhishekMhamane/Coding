public class Recursion_Power_of_Four {

  public static boolean isPowerOfFour(int n) {
    return isPowerCheck(0, n);
  }

  public static boolean isPowerCheck(int power, int n) {
    double ans = Math.pow(4, power);

    if (ans == n) return true;

    if (ans > n) return false;

    return isPowerCheck(power + 1, n);
  }

  public static void main(String[] args) {
    int n = 16;
    System.out.println(isPowerOfFour(n));
  }
}
