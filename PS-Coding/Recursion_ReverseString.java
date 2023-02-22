public class Recursion_ReverseString {

  public static void reverseString(char[] s) {
    reverseFind(s, 0, s.length - 1);

    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }

  public static char[] reverseFind(char[] s, int i, int j) {
    if (i >= j) return s;

    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;

    return reverseFind(s, i + 1, j - 1);
  }

  public static void main(String[] args) {
    char s[] = { 'h', 'e', 'l', 'l' };
    reverseString(s);
  }
}
