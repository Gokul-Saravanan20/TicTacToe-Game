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

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            System.out.println("_ _ _ _ _ _ _");
            for (int col = 0; col < 3; col++) {
                if(board[row][col] == '❌' || board[row][col] == '⬤') System.out.print("| "+ board[row][col]);
                else System.out.print("| "+ board[row][col] + " " );
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("_ _ _ _ _ _ _");
        System.out.println();
    }

}
