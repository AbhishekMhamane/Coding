import java.util.*;

public class K_ThSmallestPrimeFraction {

  public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

    int result[] = new int[2];
    PriorityQueue<double[]> pq = new PriorityQueue<>(k, Comparator.comparingDouble(o -> -o[0]));


    for(int i=0;i<arr.length-1;i++) {
      for(int j=i+1;j<arr.length;j++) {

        double fraction = (double)arr[i]/arr[j];

        if(pq.size() < k) {
          pq.add(new double[]{fraction, arr[i], arr[j]});
        } else if(fraction < pq.peek()[0]) {
            pq.poll();
            pq.add(new double[]{fraction, arr[i], arr[j]});
        }
      }
    }

    double[] res = pq.poll();
    result[0] = (int)res[1];
    result[1] = (int)res[2];

    return result;
  }

  public static void main(String[] args) {

    int arr[] = {1,2,3,5};
    int k = 3;

    int result[] = kthSmallestPrimeFraction(arr, k);
    System.out.println(result[0] + "/" + result[1]);
  }
}
