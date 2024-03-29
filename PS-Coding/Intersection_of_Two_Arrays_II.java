import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Intersection_of_Two_Arrays_II {

  public static int[] intersect(int[] nums1, int[] nums2) {

    List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
    List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
    ArrayList<Integer> result = new ArrayList<Integer>();

    for(Integer i : list1){
      if(list2.contains(i)){
        list2.remove(i);
        result.add(i);
      }
    }

    int[] arr = result.stream().mapToInt(i -> i).toArray();
    return arr;
  }

  public static void printArray(int[] arr){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
  }

  public static void main(String args[]){
    int num1[]={4,9,5};
    int num2[]={9,4,9,8,4};

    int result[]=intersect(num1,num2);
    printArray(result);
  }
}
