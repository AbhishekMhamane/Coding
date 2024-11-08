import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInMaze {

  public static class Choices{
    private static ArrayList<String> list = new ArrayList<>(Arrays.asList("U", "D", "L", "R"));
    private static int i;
    private static int j;

    public static List<String> getDirections(){
      return list;
    }

    public static  int getNewI(String direction,int i){
      if(direction == "U") return i-1;
      else if (direction == "D") return i+1;
      else return i;
    }

    public static  int getNewJ(String direction,int j){
      if(direction == "L") return j-1;
      else if (direction == "R") return j+1;
      else return j;
    }
  }

  public static void solve(int n, int arr[][]){

    if(arr[0][0] == 0){
      System.out.println("No path");
      return;
    }

    ArrayList<ArrayList<String>> res = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();
    findPath(arr,0,0,n,path,res);

    System.out.println(res);
  }

  public static void findPath(int arr[][], int i, int j, int n, ArrayList<String> path, ArrayList<ArrayList<String>> res){

    // Base condition
    if(isSolved(i,j,n,arr)){
      System.out.println("Found path...");
      res.add(new ArrayList<>(path));
      return;
    }

    // Mark cur node as visited
    arr[i][j] = 0;

    // Choices we have..

    List<String> choices = Choices.getDirections();

      for(String ch : choices){
        int newI = Choices.getNewI(ch,i);
        int newj = Choices.getNewJ(ch,j);

        if(isValid(newI,newj,n,arr)) {
        path.add(ch);
        findPath(arr, newI, newj, n, path, res);
        path.remove(path.size()-1);
      }
    }

    arr[i][j] = 1;

  }

  public static boolean isSolved(int i, int j, int n, int arr[][]){

    if ( i==n-1 && j==n-1) return true;
    return false;
  }

  public static boolean isValid(int i, int j, int n, int arr[][]){

    if(( i>=0 && j>=0) && (i<n && j<n)){
     if (arr[i][j] == 1) return true;
    }
    return false;
  }

  public static void main(String[] args) {

    int n = 5;
    int arr[][] = {{1, 0, 0, 0, 0},
                       {1, 1, 0, 1, 0},
                       {0, 1, 1, 1, 0},
                       {0, 0, 0, 1, 0},
                       {0, 0, 0, 1, 1}};
    solve(n, arr);
  }
}
