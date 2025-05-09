package TicTacToe;

public class Board {
    private final char[][] board;

    public Board(){
        board = new char[3][3];
        emptyGrid();
    }

    private void emptyGrid(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean validPlaceToMove(int row, int col, char currentPlayer){
        if(row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' '){
            board[row][col] = currentPlayer;
            return true;
        }
        else {
            return false;
        }
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
                System.out.print("| "+ board[row][col] + " " );
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ')
                    return false;
        return true;
    }
}
