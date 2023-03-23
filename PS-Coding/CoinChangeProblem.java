import java.util.Arrays;

public class CoinChangeProblem {

     public static void main(String args[])
     {
        int sum = 10;
        int arr[]={2,5,3,6};
        Arrays.sort(arr);
        System.out.println(calculate(sum,arr.length,arr));
     }

    private static int calculate(int sum,int n, int[] arr) {

      if(sum==0) return 1;

      if(sum<=0) return 0;

      if(n<=0) return 0;

      int a = calculate(sum-arr[n-1], n, arr);
      int b = calculate(sum, n-1, arr);

      return a+b;   
    }

}
