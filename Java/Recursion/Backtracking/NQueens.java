public class NQueens {
    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nQueens(board, 0);
        System.out.println("Total possible solutions are : " + count);
    }

    private static void nQueens(boolean[][] board, int row) {
        if (row == board.length) {
            count++;
            display(board);
            System.out.println();
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                nQueens(board, row + 1);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }
        // left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i])
                return false;
        }
        // right diagonal
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i])
                return false;
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                if (col == true)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}