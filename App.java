/*
    Date : Mon Sep 26 2022 13:49:08     
    Author : Suman Gurung
    Description : Sudoku Solving using Backtracking Technique 
*/

public class App {

    public static void printBoard(int[][] board) {
        System.out.print("+---+---+---+---+---+---+---+---+---+\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.print("|\n");
            System.out.print("+---+---+---+---+---+---+---+---+---+\n");

        }
    }

    public static boolean canPlace(int[][] board, int row, int col, int value) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return false;
            }
            if (board[row][i] == value) {
                return false;
            }
        }

        int smallRow = (row / 3) * 3;
        int smallCol = (col / 3) * 3;

        for (int i = smallRow; i < smallRow + 3; i++) {
            for (int j = smallCol; j < smallCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean check(int[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (canPlace(board, row, col, val)) {
                            board[row][col] = val;
                            if (check(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void solve(int[][] board) {
        if (check(board)) {
            printBoard(board);
        } else {
            System.out.println("Not Possible to solve");
        }
    }

    public static void main(String[] s) {

        int[][] board = { { 2, 0, 0, 0, 0, 0, 0, 7, 0 },
                { 6, 0, 0, 0, 3, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 5, 8, 1, 4 },
                { 0, 0, 0, 0, 7, 0, 0, 8, 0 },
                { 4, 0, 0, 0, 6, 0, 0, 0, 0 },
                { 0, 0, 8, 0, 0, 0, 1, 2, 5 },
                { 0, 5, 4, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 6, 0, 0, 0 },
                { 9, 7, 0, 3, 4, 0, 0, 0, 0 }
        };
        solve(board);
    }
}

/*
 * Input:
 * { { 7, 0, 2, 0, 5, 0, 6, 0, 0 },
 * { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
 * { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
 * { 8, 0, 0, 0, 0, 0, 0, 9, 0 },
 * { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
 * { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
 * { 0, 0, 9, 7, 0, 0, 0, 0, 5 },
 * { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
 * { 0, 0, 7, 0, 4, 0, 2, 0, 3 }
 * };
 * 
 * Output:
 * +---+---+---+---+---+---+---+---+---+
 * | 7 | 3 | 2 | 4 | 5 | 8 | 6 | 1 | 9 |
 * +---+---+---+---+---+---+---+---+---+
 * | 9 | 5 | 6 | 1 | 7 | 3 | 8 | 2 | 4 |
 * +---+---+---+---+---+---+---+---+---+
 * | 1 | 8 | 4 | 6 | 2 | 9 | 5 | 3 | 7 |
 * +---+---+---+---+---+---+---+---+---+
 * | 8 | 7 | 1 | 5 | 6 | 4 | 3 | 9 | 2 |
 * +---+---+---+---+---+---+---+---+---+
 * | 6 | 4 | 3 | 8 | 9 | 2 | 7 | 5 | 1 |
 * +---+---+---+---+---+---+---+---+---+
 * | 2 | 9 | 5 | 3 | 1 | 7 | 4 | 6 | 8 |
 * +---+---+---+---+---+---+---+---+---+
 * | 3 | 2 | 9 | 7 | 8 | 6 | 1 | 4 | 5 |
 * +---+---+---+---+---+---+---+---+---+
 * | 4 | 1 | 8 | 2 | 3 | 5 | 9 | 7 | 6 |
 * +---+---+---+---+---+---+---+---+---+
 * | 5 | 6 | 7 | 9 | 4 | 1 | 2 | 8 | 3 |
 * +---+---+---+---+---+---+---+---+---+
 * 
 * try more test cases:
 * 
 * { { 2, 0, 0, 0, 0, 0, 0, 7, 0 },
 * { 6, 0, 0, 0, 3, 0, 0, 0, 0 },
 * { 0, 0, 0, 0, 0, 5, 8, 1, 4 },
 * { 0, 0, 0, 0, 7, 0, 0, 8, 0 },
 * { 4, 0, 0, 0, 6, 0, 0, 0, 0 },
 * { 0, 0, 8, 0, 0, 0, 1, 2, 5 },
 * { 0, 5, 4, 0, 0, 0, 0, 0, 0 },
 * { 0, 0, 0, 9, 0, 6, 0, 0, 0 },
 * { 9, 7, 0, 3, 4, 0, 0, 0, 0 }
 * };
 */
