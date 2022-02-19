import java.util.*;

public class Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, c, i, j, board[][];
        System.out.println("Enter number of rows and columns in maze :");
        r = sc.nextInt();
        c = sc.nextInt();
        board = new int[r][c];
        System.out.println("Enter maze values ( 1 for valid path and 0 for hurdle ) : ");
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println("The required possible solutions of the maze are :");

        pathRestrictions("", board, 0, 0);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p + 'D', r - 1, c);
        }

        if (c > 1) {
            path(p + 'R', r, c - 1);
        }
    }

    static ArrayList<String> pathRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(pathRet(p + 'D', r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathRet(p + 'R', r, c - 1));
        }

        return list;
    }

    static ArrayList<String> pathRetDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (r > 1 && c > 1) {
            list.addAll(pathRetDiagonal(p + 'D', r - 1, c - 1));
        }

        if (r > 1) {
            list.addAll(pathRetDiagonal(p + 'V', r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathRetDiagonal(p + 'H', r, c - 1));
        }

        return list;
    }

    static void pathRestrictions(String p, int[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c] == 0) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestrictions(p + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            pathRestrictions(p + 'R', maze, r, c + 1);
        }
    }

}