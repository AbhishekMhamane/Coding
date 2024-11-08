public class WordSearch {

  public static boolean exist(char[][] board, String word) {

    for(int i=0;i<board.length;i++)
    {
      for(int j=0;j<board[0].length;j++){
        if(board[i][j] == word.charAt(0)){
          boolean temp = isExist(board,new int[board.length][board[0].length],i,j,word,0);
          if(temp){
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean isExist(char[][] board,int visited[][],int row,int col,String word,int index){

    if(index == word.length()){
      return true;
    }

    if((row < 0 || row >= board.length) ){
      return false;
    }

    if(col < 0 || col >= board[0].length){
      return false;
    }

    if(visited[row][col]!=1 && board[row][col] == word.charAt(index)){

      visited[row][col] = 1;

      if(isExist(board,visited,row-1,col,word,index+1) || isExist(board,visited,row+1,col,word,index+1) ||
              isExist(board,visited,row,col-1,word,index+1) || isExist(board,visited,row,col+1,word,index+1)){
        return true;
      }

      visited[row][col] = 0;
    }

    return false;
  }

  public static void main(String[] args) {
    char arr[][] = new char[][]{{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}};
    String word = "ABCESEEEFS";
    System.out.println("Is Word Present ? " + exist(arr, word));
  }
}
