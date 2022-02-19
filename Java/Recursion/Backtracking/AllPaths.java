import java.util.*;

public class AllPaths {
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

        int[][] path = new int[board.length][board[0].length];
        System.out.println("The required possible solutions of the maze are :");

        allPathPrint("", board, 0, 0, path, 1);
    }

    static void allPath(String p, int[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println("\n" + p);
            return;
        }

        if (maze[r][c] == 0) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = 0;

        if (r < maze.length - 1) {
            allPath(p + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(p + 'R', maze, r, c + 1);
        }

        if (r > 0) {
            allPath(p + 'U', maze, r - 1, c);
        }

        if (c > 0) {
            allPath(p + 'L', maze, r, c - 1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made
        // by that function
        maze[r][c] = 1;
    }

    static void allPathPrint(String p, int[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (maze[r][c] == 0) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = 0;
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + 'R', maze, r, c + 1, path, step + 1);
        }

        if (r > 0) {
            allPathPrint(p + 'U', maze, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            allPathPrint(p + 'L', maze, r, c - 1, path, step + 1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made
        // by that function
        maze[r][c] = 1;
        path[r][c] = 0;
    }
}
