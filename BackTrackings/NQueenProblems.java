package BackTrackings;
public class NQueenProblems {
    public static void main(String[] args) {
        int n=4;
        char[][] chess_board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess_board[i][j]='X';
            }
        }
        nQueen(chess_board,0);
    }
    private static void nQueen(char[][] chessBoard, int row) {
        int n=chessBoard.length;
        if(row==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(chessBoard[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j=0;j<n;j++) {
            if (isSafe(chessBoard, row,j)) {
                chessBoard[row][j] = 'Q';
                nQueen(chessBoard, row + 1);
                chessBoard[row][j] = 'X';
            }
        }
    }
    private static boolean isSafe(char[][] chessBoard, int row,int col) {
        int n=chessBoard.length;
        //row check
        for(int j=0;j<n;j++){
            if(chessBoard[row][j]=='Q') return false;
        }
        //column check
        for(int i=0;i<n;i++){
            if(chessBoard[i][col]=='Q') return false;
        }
        //check north-east
        int i=row;
        int j=col;
        while(i>=0 && j<n){
            if(chessBoard[i][j]=='Q')return false;
            i--;
            j++;
        }
        //check south-east
        i=row;
        j=col;
        while (i<n && j<n){
            if(chessBoard[i][j]=='Q')return false;
            i++;
            j++;
        }
        //check south-west
        i=row;
        j=col;
        while (i<n && j>=0){
            if(chessBoard[i][j]=='Q')return false;
            i++;
            j--;
        }
        //check north-west
        i=row;
        j=col;
        while (i>=0 && j>=0){
            if(chessBoard[i][j]=='Q')return false;
            i--;
            j--;
        }
        return true;
    }
}
