public class NKnights {
    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nKnights(board, 0);
        System.out.println("Total possible solutions are : " + count);
    }

    private static void nKnights(boolean[][] board, int row) {
        if (row == board.length) {
            count++;
            display(board);
            System.out.println();
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                nKnights(board, row + 1);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1])
                return false;
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1])
                return false;
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2])
                return false;
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2])
                return false;
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length)
            return true;

        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                if (col == true)
                    System.out.print("K ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}