import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossiblePathsFromLeftToRightMatix {

  public List<List<Integer>> solve(int [][] matrix){
    List<List<Integer>> result = new ArrayList<>();
    int [][] visited = new int[matrix.length][matrix[0].length];
    for(int i=0;i<visited.length;i++){
      Arrays.fill(visited[i],0);
    }
    findPath(0, 0, new ArrayList<Integer>(), result, matrix, visited);
    return  result;
  }

  public void findPath(int i, int j, List<Integer> path,  List<List<Integer>> result, int[][] matrix, int[][] visited){

    // bc
    if(i == matrix.length-1 && j == matrix[0].length-1){
      path.add(matrix[i][j]);
      result.add(new ArrayList<>(path));
      path.remove(path.size() - 1);
    }

    visited[i][j] = 1;
    path.add(matrix[i][j]);

    //choices

    if(isValidCall(i+1,j,visited)){
      findPath(i+1, j, path, result, matrix, visited);
    }

    if(isValidCall(i,j+1,visited)){
      findPath(i, j+1, path, result, matrix, visited);
    }

    path.remove(path.size() - 1);
    visited[i][j] = 0;
  }

  public boolean isValidCall(int i, int j, int visited[][]){
    return (i < visited.length && i >=0 ) && (j < visited[0].length && j>=0) && (visited[i][j]==0);
  }

  public static void main(String[] args) {
    PossiblePathsFromLeftToRightMatix obj = new PossiblePathsFromLeftToRightMatix();

    int[][] matrix = {
            {1, 2, 3,4,5,6,7},
            {1, 2, 3,4,5,6,7},
            {1, 2, 3,4,5,6,7}
    };

    System.out.println(obj.solve(matrix));
  }
}
