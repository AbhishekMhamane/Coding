import java.util.ArrayList;
import java.util.List;

public class NQueensII {

  int count = 0;

  public int totalNQueens(int n) {
    boolean visited[][] = new boolean[n][n];
    solve(0, n, visited, new ArrayList<Integer>());
    return count;
  }

  public void solve(int col, int n, boolean visited[][], List<Integer> temp){

    // bc
    if(col>=n) {
      count = count +1;
      return;
    }

    // choices
    for(int i=0; i<n; i++){
      if(!visited[i][col]){
        if(isValidCheck(i, col, visited)){
          visited[i][col] = true;
          solve(col+1, n, visited, temp);
          visited[i][col] = false;
        }
      }
    }
  }

  public boolean isValidCheck(int row, int col, boolean visited[][]){
    // row check
    for(int i=0; i<visited.length; i++){
      if(visited[i][col]) return false;
    }

    // col check
    for(int i=0; i<visited[0].length; i++){
      if(visited[row][i]) return false;
    }

    // digonals check
    // left up check
    int i=row, j=col;
    while(i>=0 && j>=0){
      if(visited[i][j]) return false;
      i--;
      j--;
    }

    // left down check
    i=row; j=col;
    while(i<visited.length && j>=0){
      if(visited[i][j]) return false;
      i++;
      j--;
    }

    return true;
  }

  public static void main(String[] args) {
    NQueensII ob = new NQueensII();
    int n = 1;
    System.out.println(ob.totalNQueens(n));
  }
}
