import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TugOfWar {

  boolean minVisited[];

  public  List<List<Integer>>  tugOfWar(int arr[]){
    boolean visited[] = new boolean[arr.length];
    Arrays.fill(visited,false);
    int totalSum=0;
    for(int i=0; i<arr.length; i++){
      totalSum += arr[i];
    }
    int minSum[] = {Integer.MAX_VALUE};
    helpMe(0, arr, visited, totalSum, 0, 0, minSum);

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> subset1 = new ArrayList<>();
    List<Integer> subset2 = new ArrayList<>();
    for(int i=0; i< arr.length; i++){
      if(minVisited[i]){
        subset1.add(arr[i]);
      }else{
        subset2.add(arr[i]);
      }
    }
    lists.add(subset1);
    lists.add(subset2);
    return lists;
  }

  public void helpMe(int index, int arr[], boolean visited[], int totalSum, int sum, int selected, int minSum[]){

    // bc
    if(index >= arr.length) return;

    // choices
    // exclude
    helpMe(index + 1, arr, visited, totalSum, sum, selected, minSum);

    //include
    visited[index] = true;
    sum += arr[index];
    selected++;

    if(selected == (arr.length/2)){
      int diff = Math.abs((totalSum/2) - sum);
      if(diff < minSum[0]){
        minSum[0] = diff;
        minVisited = visited.clone();
      }
    }else{
      helpMe(index+1, arr, visited, totalSum, sum, selected, minSum);
    }
    // backtrack
    visited[index] = false;
  }


  public static void main(String[] args) {
    TugOfWar obj = new TugOfWar();
    int arr[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
    System.out.println(obj.tugOfWar(arr));
  }
}
