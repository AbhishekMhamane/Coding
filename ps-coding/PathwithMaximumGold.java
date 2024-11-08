public class PathwithMaximumGold {

  public static int getMaximumGold(int[][] grid) {

    int max = 0;

    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
        max = Math.max(max,findPathMaximumGold(grid, i, j, 0, new boolean[grid.length][grid[0].length]));
      }
    }

    return max;
  }

  public static int findPathMaximumGold(int grid[][], int i, int j, int sum, boolean visited[][]){

    // base condition
    if(i<0 || i>=grid.length) return sum;
    if(j<0 || j>=grid[0].length) return sum;
    if(visited[i][j]) return sum;
    if(grid[i][j] == 0) return sum;

    // mark the cell as visited
    visited[i][j] = true;

    // get the current cell value
    sum = sum + grid[i][j];

    // get the maximum value from the 4 directions
    int up = findPathMaximumGold(grid, i-1, j, sum, visited);
    int down = findPathMaximumGold(grid, i+1, j, sum, visited);
    int left = findPathMaximumGold(grid, i, j-1, sum, visited);
    int right = findPathMaximumGold(grid, i, j+1, sum, visited);

    // mark the cell as unvisited
    visited[i][j] = false;

    return Math.max(up, Math.max(down, Math.max(left, right)));
  }

  public static void main(String[] args) {
    int grid[][] = {{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}};
    int result = getMaximumGold(grid);
    System.out.println(result);
  }
}
