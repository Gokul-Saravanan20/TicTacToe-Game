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
            boolean placeStatus = board.validPlaceToMove(arr,board.board);
            if(placeStatus){
                board.board[arr[0]][arr[1]] = currentPlayer;
                isGameEnded = board.isWin(currentPlayer);
                if(isGameEnded){
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " has WON the Match");
                }
                else currentPlayer = switchPlayer(currentPlayer);
                if (board.isFull()) {
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



}
