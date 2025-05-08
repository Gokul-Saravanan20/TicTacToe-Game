import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int row = 0,col = 0,count = 0;
        Scanner scanner = new Scanner(System.in);
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean isEnd = false;

        while (!isEnd && count < 6){
            printBoard(board);
            System.out.print("Player " + player + " enter : ");
             row = scanner.nextInt();
             col = scanner.nextInt();

            if((row >= 0 && row < 3) && (col >= 0 && col < 3) && board[row][col] == ' '){
                count++;
                if (count == 6) System.out.println("This Game Ends On Draw");
                board[row][col] = player;
                isEnd = isGameOver(board,player);
                if(isEnd){
                    System.out.println("Player "+player + " Won the Match");
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("!Invalid Move : Try Again");
            }
        }
        printBoard(board);

    }

    private static boolean isGameOver(char[][] board, char player) {

        //check for row
        for (int row = 0; row < 3; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) return true;
        }

        //check for col
        for (int col = 0; col < 3; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) return true;
        }

        //check for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("| "+ board[row][col] + " " );
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }
}
