public class RecursionArrayPermutation {

  public static void findPermutation(int arr[], int start, int end) {
    //base condition
    if (start >= end) {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i < end; i++) {
      swap(arr, start, i);
      findPermutation(arr, start + 1, end);
      swap(arr, start, i);
    }
  }

  public static void swap(int[] arr, int index, int end) {
    int temp = arr[index];
    arr[index] = arr[end];
    arr[end] = temp;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
    findPermutation(arr, 0, arr.length);
  }
}
