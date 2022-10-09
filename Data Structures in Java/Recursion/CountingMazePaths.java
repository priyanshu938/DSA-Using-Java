import java.util.*;

public class CountingMazePaths {
    public static void main(String[] args) {
        System.out.println(countMaze(3, 3));
        printMazePath(3, 3, "");
        System.out.println(returnPrintMazePathList(3, 3, ""));
        System.out.println(returnDiagVertHorPath(3, 3, ""));
        boolean[][] board = {
                { true, true, true },
                { true, true, true },
                { true, true, true }

        };
        int[][] path = new int[board.length][board[0].length];
        restrictionPath(0, 0, board, "");
        restrictionPathDiagonalMoveAllowed(0, 0, board, "");
        allPaths(0, 0, board, "");
        allPathsPrint(0, 0, board, path, "", 1);
    }

    private static void restrictionPath(int r, int c, boolean[][] board, String s) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(s);
            return;
        }
        if (!board[r][c])
            return;
        if (r < board.length - 1)
            restrictionPath(r + 1, c, board, s + "D");
        if (c < board[0].length - 1)
            restrictionPath(r, c + 1, board, s + "R");
    }

    private static void restrictionPathDiagonalMoveAllowed(int r, int c, boolean[][] board, String s) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(s);
            return;
        }
        if (!board[r][c])
            return;
        if (r < board.length - 1 && c < board[0].length - 1)
            restrictionPathDiagonalMoveAllowed(r + 1, c + 1, board, s + "D");
        if (r < board.length - 1)
            restrictionPathDiagonalMoveAllowed(r + 1, c, board, s + "V");
        if (c < board[0].length - 1)
            restrictionPathDiagonalMoveAllowed(r, c + 1, board, s + "H");
    }

    private static List<String> returnDiagVertHorPath(int r, int c, String s) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }
        List<String> list = new ArrayList<String>();
        if (r > 1 && c > 1)// For diaognal
        {
            list.addAll(returnDiagVertHorPath(r - 1, c - 1, s + "D"));
        }
        if (r > 1)// For row
        {
            list.addAll(returnDiagVertHorPath(r - 1, c, s + "V"));
        }
        if (c > 1)// for column
        {
            list.addAll(returnDiagVertHorPath(r, c - 1, s + "H"));
        }
        return list;
    }

    private static List<String> returnPrintMazePathList(int r, int c, String s) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }
        List<String> list = new ArrayList<String>();
        if (r > 1) {
            list.addAll(returnPrintMazePathList(r - 1, c, s + "D"));
        }
        if (c > 1) {
            list.addAll(returnPrintMazePathList(r, c - 1, s + "R"));
        }
        return list;
    }

    private static int countMaze(int r, int c) {
        if (r == 1 || c == 1)
            return 1;
        return countMaze(r - 1, c) + countMaze(r, c - 1);
    }

    private static void printMazePath(int r, int c, String s) {
        if (r == 1 && c == 1) {
            System.out.println(s);
            return;
        }
        if (r > 1) {
            printMazePath(r - 1, c, s + "D");
        }
        if (c > 1) {
            printMazePath(r, c - 1, s + "R");
        }

    }

    // backtracking
    private static void allPaths(int r, int c, boolean[][] board, String s) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(s);
            return;
        }

        if (!board[r][c])
            return;
        board[r][c] = false;
        if (r < board.length - 1)
            allPaths(r + 1, c, board, s + "D");

        if (c < board[0].length - 1)
            allPaths(r, c + 1, board, s + "R");

        if (r > 0)
            allPaths(r - 1, c, board, s + "U");

        if (c > 0)
            allPaths(r, c - 1, board, s + "L");
        board[r][c] = true;
    }

    private static void allPathsPrint(int r, int c, boolean[][] board, int[][] path, String s, int step) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            System.out.println(s);
            System.out.println();
            return;
        }

        if (!board[r][c])
            return;
        board[r][c] = false;
        path[r][c] = step;
        if (r < board.length - 1)
            allPathsPrint(r + 1, c, board, path, s + "D", step + 1);

        if (c < board[0].length - 1)
            allPathsPrint(r, c + 1, board, path, s + "R", step + 1);

        if (r > 0)
            allPathsPrint(r - 1, c, board, path, s + "U", step + 1);

        if (c > 0)
            allPathsPrint(r, c - 1, board, path, s + "L", step + 1);
        board[r][c] = true;
        path[r][c] = 0;
    }

}
