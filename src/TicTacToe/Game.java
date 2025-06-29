package TicTacToe;

import java.util.Scanner;

public class Game {
    private final Board board;
    private  char currentPlayer;

    public Game(){
        board = new Board();
        currentPlayer = '❌';
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean isGameEnded = false;

        while (!isGameEnded){
            board.printBoard();
            System.out.print("Enter the place Value : ");
            int place = scanner.nextInt();
            int[] arr = choosePlace(place);
            boolean placeStatus = validPlaceToMove(arr,board.board);
            if(placeStatus){
                board.board[arr[0]][arr[1]] = currentPlayer;
                isGameEnded = isWin(currentPlayer);
                if(isGameEnded){
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " has WON the Match");
                    return;
                }
                else currentPlayer = switchPlayer(currentPlayer);
                if (isFull()) {
                    board.printBoard();
                    System.out.println("This Game Ends On Draw");
                    isGameEnded = true;
                }

            }else{
                System.out.println("Enter a Valid Place!");
            }
        }

    }

    private char switchPlayer(char currentPlayer){
        return (currentPlayer == '❌') ? '⬤' : '❌';
    }

    public static int[] choosePlace(int n){
        return switch (n) {
            case 1 -> new int[]{0, 0};
            case 2 -> new int[]{0, 1};
            case 3 -> new int[]{0, 2};
            case 4 -> new int[]{1, 0};
            case 5 -> new int[]{1, 1};
            case 6 -> new int[]{1, 2};
            case 7 -> new int[]{2, 0};
            case 8 -> new int[]{2, 1};
            case 9 -> new int[]{2, 2};
            default -> new int[]{-1, -1};
        };
    }

    public boolean isFull() {
        for (char[] row : board.board)
            for (char cell : row)
                if (       cell == '1' || cell == '2' || cell == '3'
                        || cell == '4' || cell == '5' || cell == '6'
                        || cell == '7' || cell == '8' || cell == '9')
                    return false;
        return true;
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
            if ((board.board[check][0] == player && board.board[check][1] == player && board.board[check][2] == player) ||
                    (board.board[0][check] == player && board.board[1][check] == player && board.board[2][check] == player))
                return true;

        return (board.board[0][0] == player && board.board[1][1] == player && board.board[2][2] == player) ||
                (board.board[0][2] == player && board.board[1][1] == player && board.board[2][0] == player);
    }

}
