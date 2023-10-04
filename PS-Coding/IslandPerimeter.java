public class IslandPerimeter {

  public static int islandPerimeter(int[][] grid) {
    int totalCount = 0;
    int rowLength = grid.length;

    for (int i = 0; i < rowLength; i++) {
      int colLength = grid[i].length;

      for (int j = 0; j < colLength; j++) {
        int tempTotalCount = 4;

        if (grid[i][j] == 1) {
          if ((i - 1 >= 0) && (grid[i - 1][j] == 1)) {
            tempTotalCount = tempTotalCount - 1;
          }
          if ((i + 1 <= rowLength - 1) && (grid[i + 1][j] == 1)) {
            tempTotalCount = tempTotalCount - 1;
          }
          if ((j - 1 >= 0) && (grid[i][j - 1] == 1)) {
            tempTotalCount = tempTotalCount - 1;
          }
          if ((j + 1 <= colLength - 1) && (grid[i][j + 1] == 1)) {
            tempTotalCount = tempTotalCount - 1;
          }

          totalCount = totalCount + tempTotalCount;
        }
      }
    }
    return totalCount;
  }

  public static void main(String[] args) {
    int grid[][] = { { 0, 1 } };
    int result = islandPerimeter(grid);
    System.out.println("result = " + result);
  }
}
