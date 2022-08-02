public class Recursion_Pow {

  public static double power(double x, int n) {
    if (n == 0) {
      return 1;
    }

    double ans = power(x, n / 2);

    if (n % 2 == 0) {
      return ans * ans;
    } else {
      return ans * ans * x;
    }
    // return (x * myPow(x, n - 1));
  }

  public static double myPow(double x, int n) {
    if (n < 0) {
      double result = power(x, Math.abs(n));
      return (1 / result);
    }

    return power(x, n);
  }

  public static void main(String[] args) {
    double a = 2;
    int b = -2;
    double result = myPow(a, b);
    System.out.println(result);
  }
}
