import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int row = 0,col = 0,count = 0;

        Scanner scanner = new Scanner(System.in);

        emptyGrid(board);

        char player = 'X';
        boolean isEnd = false;

        while (!isEnd && count < 9){
            printBoard(board);
            System.out.print("Player " + player + " enter : ");
             row = scanner.nextInt();
             col = scanner.nextInt();

            if((row >= 0 && row < 3) && (col >= 0 && col < 3) && board[row][col] == ' '){
                count++;
                board[row][col] = player;
                isEnd = isGameOver(board,player);
                if(isEnd){
                    System.out.println();
                    System.out.println("Player "+player + " Won the Match");
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                    System.out.println();
                    if (count == 9) System.out.println("This Game Ends On Draw");
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
        else return board[0][2] == player && board[1][1] == player && board[2][0] == player;
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

    private static void emptyGrid(char[][] board){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }
}
