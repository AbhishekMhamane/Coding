import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NQueens {

  public  List<List<Integer>> nQueens(int n){
    boolean visited[][] = new boolean[n+1][n+1];
    List<List<Integer>> result = new ArrayList<>();
    for(int i=0; i<visited.length; i++){
      Arrays.fill(visited[i], false);
    }
    solve(1, n, new ArrayList<Integer>(), visited, result);
    return result;
  }

  public void solve(int col, int n, List<Integer> temp, boolean visited[][], List<List<Integer>> result){

    //bc
    if(col>n) {
      result.add(new ArrayList<>(temp));
      return;
    }

    // choices
    // try for each row
    for(int i=1; i<=n; i++){
      if(!visited[i][col]){
        if(isCheckSafe(i, col, visited)){
          visited[i][col] = true;
          // add queen
          temp.add(i);
          solve(col + 1, n, temp,visited, result);
          //backtrack
          temp.remove(temp.size()-1);
          visited[i][col] = false;
        }
      }
    }
  }

  public boolean isCheckSafe(int row, int col, boolean visited[][]){

    int i = row, j=col;
    //up left
    while(i>0 && j>0){
      if(visited[i][j]) return false;
      i--;
      j--;
    }

    // up left
    i = row; j=col;
    while(i<visited.length && j>0){
      if(visited[i][j]) return false;
      i++;
      j--;
    }

    // row
    for(int k=1; k<visited.length; k++){
      if(visited[k][col]) return false;
    }

    // col
    for(int k=1; k<visited.length; k++){
      if(visited[row][k]) return false;
    }

    return true;
  }

  public boolean isCheckValid(int row, int col, boolean visited[][]){

    int i = row, j=col;
    //up left
    while(i>=0 && j>=0){
      if(visited[i][j]) return false;
      i--;
      j--;
    }

    // up left
    i = row; j=col;
    while(i<visited.length && j>=0){
      if(visited[i][j]) return false;
      i++;
      j--;
    }

    // row
    for(int k=0; k<visited.length; k++){
      if(visited[k][col]) return false;
    }

    // col
    for(int k=0; k<visited.length; k++){
      if(visited[row][k]) return false;
    }

    return true;
  }

  public List<List<String>> solveNQueens(int n) {
    boolean visited[][] = new boolean[n+1][n+1];
    List<List<String>> result = new ArrayList<>();
    if(n == 1) {
      result.add(new ArrayList<>(Arrays.asList("Q")));
      return result;
    }

    StringBuilder builder = new StringBuilder();
    for(int i=0; i<visited.length; i++){
      Arrays.fill(visited[i], false);
      builder.append(".");
    }
    builder.delete(builder.length()-1, builder.length());
    solveMe(1, n, new ArrayList<String>(), visited, result, builder.toString());
    return result;
  }

  public void solveMe(int col, int n, List<String> temp, boolean visited[][], List<List<String>> result, String str){

    //bc
    if(col>n) {
      result.add(new ArrayList<>(temp));
      return;
    }

    // choices
    // try for each row
    for(int i=0; i<n; i++){
      if(!visited[i][col]){
        if(isCheckValid(i, col, visited)){
          visited[i][col] = true;
          // add queen
          temp.add(getString(i, str));
          solveMe(col + 1, n, temp,visited, result, str);
          //backtrack
          temp.remove(temp.size()-1);
          visited[i][col] = false;
        }
      }
    }
  }

  public String getString(int position, String input){
    String replacement = "Q";
    String regex = String.format("^(.{%d})(.)(.*)$", position);
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    String result = "";
    if (matcher.find()) {
      result = matcher.replaceAll("$1" + replacement + "$3");
    }
    return result;
  }

  public static void main(String[] args) {
    NQueens obj = new NQueens();
    int n = 4;
    System.out.println(obj.nQueens(n));
    System.out.println(obj.solveNQueens(n));
  }
}
