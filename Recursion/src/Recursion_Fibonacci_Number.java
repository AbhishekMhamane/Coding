public class Recursion_Fibonacci_Number {

  public static int fib(int n) {
    if (n == 0) return 0;

    if (n == 1 || n == 2) return 1;

    return fib(n - 2) + fib(n - 1);
  }

  public static void main(String args[]) {
    int n = 6;
    int result = fib(n);
    System.out.println(result);
  }
}
