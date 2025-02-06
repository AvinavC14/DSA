public class NQueens {
 public static void main(String[] args) {
    int n=4;
    boolean[][] board=new boolean [n][n];
    System.out.println(queen(board, 0));
 }  
 static int queen(boolean [][]board,int row){
    if(row==board.length){
        display(board);
        System.out.println();
        return 1;
    }
    int count=0;
    //checking by placing queen in each column
    for(int col=0;col<board.length;col++){
        if(isSafe(board,row,col)){
         board[row][col]=true;
         count=count+queen(board, row+1);
         board[row][col]=false;
        }
    }
    return count;
 } 
 static void display(boolean [][]board){
    for(boolean []row:board){
        for(boolean element:row){
            if(element){
                System.out.print(" Q ");
            }
            else{
                System.out.print(" X ");
            }
        }
        System.out.println();
    }
 }
 static boolean isSafe(boolean[][]board,int row,int col){
    //checking vertically
    for (int i = 0; i <row; i++) {
        if(board[i][col]){
            return false;
        }
    }
 
    //checking left diagonal
    int maxleft=Math.min(row,col);
    for (int j = 1; j <= maxleft; j++) {
        if(board[row-j][col-j]){
            return false;
        }
    }
    //checking right diagonal
    int maxright=Math.min(row,board.length-1-col);
  for (int k = 1; k <= maxright; k++) {
    if(board[row-k][col+k]){
        return false;
    }
  }
  return true;
 }
}
