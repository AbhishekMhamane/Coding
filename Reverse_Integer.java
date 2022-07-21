import java.util.*;

public class Reverse_Integer {

  public static int performReverseInteger(int number) {
    if (number < 10 && number > -10) {
      return number;
    }

    long reverseInteger = 0;

    while (number != 0) {
      int lastElement = number % 10;
      reverseInteger = reverseInteger * 10 + lastElement;
      number = number / 10;
    }

    return (
        reverseInteger >= Integer.MIN_VALUE &&
        reverseInteger <= Integer.MAX_VALUE
      )
      ? (int) reverseInteger
      : 0;
  }

  public static void main(String[] args) {
    int input = -123;
    System.out.println("Integer as input : " + input);
    int reverseInteger = performReverseInteger(input);
    System.out.println("Reversed Integer is : " + reverseInteger);
  }
}
