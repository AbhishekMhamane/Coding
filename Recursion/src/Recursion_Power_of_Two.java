public class Recursion_Power_of_Two {

  public static boolean isPowerOfTwo(int n) {
    return checkPower(0, n);
  }

  public static boolean checkPower(int power, int n) {
    double ans = Math.pow(2, power);

    System.out.println(ans + " " + power + " " + n);

    if (ans == n) return true;

    if (ans > n) return false;

    power++;

    boolean isCheck = checkPower(power, n);

    return isCheck;
  }

  public static void main(String args[]) {
    int n = 8;
    System.out.println(isPowerOfTwo(n));
  }
}
