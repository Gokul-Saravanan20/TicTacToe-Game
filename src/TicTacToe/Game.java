package TicTacToe;

import java.util.Scanner;

public class Game {
    private final Board board;
    private char currentPlayer;

    public Game(){
        board = new Board();
        currentPlayer = 'X';
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean isGameEnded = false;

        while (!isGameEnded){
            board.printBoard();
            System.out.println("Player " + currentPlayer + " Enter row and column (0 - 2): ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if(board.validPlaceToMove(row,column,currentPlayer)){
                if(board.isWin(currentPlayer)){
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " has Won the Match");
                    isGameEnded = true;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("This Game Ends on Draw");
                    isGameEnded = true;
                }else{
                   currentPlayer =  switchPlayer(currentPlayer);
                }
            }else{
                System.out.println("!Invalid Move : Please try Again");
            }
        }
    }

    private char switchPlayer(char currentPlayer){
        return (currentPlayer == 'X') ? 'O' : 'X';
    }



}
