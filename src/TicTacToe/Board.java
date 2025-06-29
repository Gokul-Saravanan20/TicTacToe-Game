package TicTacToe;

public class Board {
      char[][] board;

    public Board(){
        board = new char[3][3];
        emptyGrid();
    }

    private void emptyGrid(){
        char temp = 49;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = temp++;
            }
        }
    }

    public  boolean validPlaceToMove(int[] arr,char[][] board){
        int x = arr[0];
        int y = arr[1];

        if(x == -1) return false;
        else if (board[x][y] == '❌') return false;
        else return board[x][y] != '⬤';
    }

    public boolean isWin(char player) {
        for (int check = 0; check < 3; check++)
            if ((board[check][0] == player && board[check][1] == player && board[check][2] == player) ||
                    (board[0][check] == player && board[1][check] == player && board[2][check] == player))
                return true;

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if(board[row][col] == '❌' || board[row][col] == '⬤') System.out.print("| "+ board[row][col]);
                else System.out.print("| "+ board[row][col] + " " );
            }
            System.out.print("|");
            System.out.println();
            System.out.println("_ _ _ _ _ _ _");
        }
        System.out.println();
    }

    public boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (       cell == '1' || cell == '2' || cell == '3'
                        || cell == '4' || cell == '5' || cell == '6'
                        || cell == '7' || cell == '8' || cell == '9')
                    return false;
        return true;
    }
}
