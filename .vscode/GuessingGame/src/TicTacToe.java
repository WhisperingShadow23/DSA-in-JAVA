// public Certainly! Here's a simple command-line Tic-Tac-Toe game implemented in Java:

// ```java
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < 9) {
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                moves++;
                displayBoard();
                gameWon = checkWinner(row, col);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + currentPlayer + " wins!");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int[] getPlayerMove() {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] move = new int[2];

            System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
            move[0] = scanner.nextInt();
            System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
            move[1] = scanner.nextInt();

            return move;
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private static boolean checkWinner(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
               (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
               (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}
// ```

// Copy and paste this code into a Java file in your IDE or a text editor, then run the program. This code provides a basic command-line interface for a Tic-Tac-Toe game. Players take turns entering row and column coordinates to place their 'X' or 'O' on the board. The game checks for a winner after each move and ends when a player wins or the board is full. {
    
// }
