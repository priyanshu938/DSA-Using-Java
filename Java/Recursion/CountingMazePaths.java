import java.util.*;
public class CountingMazePaths {
    public static void main(String[] args) {
        System.out.println(countMaze(3, 3));
        printMazePath(3, 3, "");
        System.out.println(returnPrintMazePathList(3, 3, ""));
        System.out.println(returnDiagVertHorPath(3, 3, ""));
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

}
