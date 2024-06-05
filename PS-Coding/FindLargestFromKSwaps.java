public class FindLargestFromKSwaps {

  public static String findLargest(String s, int k){
    String result = s;
    return findLargestHelper(s.toCharArray(),result, k, 0);
  }

  public static String  findLargestHelper(char s[], String result, int k, int index) {

    // base condition
    if(k== 0 || index == s.length){
      return result;
    }

    // find the maximum element from the remaining elements
    char max = findMax(s, index);

    for(int i=index+1; i<s.length; i++){

      // control recursion
      if(s[i] > s[index] && s[i] == max) {
        swap(s, index, i);
        String temp = String.valueOf(s);
        if(result.compareTo(temp) < 0){
          result = temp;
        }
        result = findLargestHelper(s, result, k + 1, index + 1);
        //backtrack
        swap(s, index, i);
      }
    }

    return result;
  }

  private static void swap(char s[], int index, int i) {
    char temp = s[index];
    s[index] = s[i];
    s[i] = temp;
  }

  private static char findMax(char[] s, int index) {

    char max = Character.MIN_VALUE;

    for(int i=index; i<s.length; i++){
      if(s[i] > max){
        max = s[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String s = "4577";
    int k = 2;
    System.out.println(findLargest(s, k));
  }
}
