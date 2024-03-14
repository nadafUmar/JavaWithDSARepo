package BackTrackings;
public class MaxNightsPlacedInChessBoard {
    public static int number=8;
    public static int maxknights=-1;

    public static void main(String[] args) {
        int n=4;
        char[][] chess_board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess_board[i][j]='x';
            }
        }
        maxKnightsPlaced(chess_board,0,0,0);
        System.out.println("max knights placed is "+maxknights);
    }
    private static void maxKnightsPlaced(char[][] chessBoard, int row,int col,int num) {
        int n=chessBoard.length;
        if(row==n) {
            if(num==number) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(chessBoard[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            maxknights=Math.max(maxknights,num);
            return;
        }else if(isSafe(chessBoard,row,col)){
            chessBoard[row][col]='k';
            if(col!=n-1)maxKnightsPlaced(chessBoard,row,col+1,num+1);
            else maxKnightsPlaced(chessBoard,row+1,0,num+1);
            chessBoard[row][col]='x';
        }
        if(col!=n-1)maxKnightsPlaced(chessBoard,row,col+1,num);
        else maxKnightsPlaced(chessBoard,row+1,0,num);
    }
    public static boolean isSafe(char[][] chess_board, int row,int col) {
        int len=chess_board.length;
        if (row-2>=0 && col+1<len && chess_board[row - 2][col + 1] == 'k') { // top right
            return false;
        }
        if (row-2>=0 && col-1>=0 && chess_board[row - 2][col - 1] == 'k') { // top left
           return false;
        }
        if (row-1>=0 && col+2<len && chess_board[row - 1][col + 2] == 'k') { // right up
            return false;
        }
        if(row-1>=0 && col-2>=0 && chess_board[row-1][col-2]=='k'){ //left up
           return false;
        }
       if (row+2<len && col-1>=0 && chess_board[row + 2][col - 1] =='k' ) { // down left
          return false;
        }
       if (row+2<len && col+1<len && chess_board[row + 2][col + 1] =='k' ) { // down right
            return false;
        }
       if (row+1<len && col+2<len && chess_board[row + 1][col + 2] == 'k') { // right down
          return false;
        }
       if (row+1<len && col-2>=0 && chess_board[row + 1][col - 2] == 'k') { // left down
           return false;
        }
        return true;
    }
}
