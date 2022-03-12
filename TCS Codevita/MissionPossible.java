
import java.util.*;

public class MissionPossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inpN = sc.nextLine().split(" ");
        int n = Integer.parseInt(inpN[0]);
        String initPosition[] = sc.next().split(",");
        int startRow = Integer.parseInt(initPosition[0]);
        int startCol = Integer.parseInt(initPosition[1]);
        String path = "";
        int max = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String pos[] = sc.next().split(",");
            int point = sc.nextInt();
            int row = Integer.parseInt(pos[0]);
            int col = Integer.parseInt(pos[1]);
            arr[row][col] = point;
            if (point > max)
                max = point;

        }
        char ch;
        do {
            ch = sc.next().charAt(0);
            if (ch == 'Q')
                break;
            path += ch;
        } while (ch != 'Q');
        maxPoints(arr, startRow, startCol, path + "Q", n, max);
    }

    static void maxPoints(int[][] arr, int posr, int posc, String path, int cell, int max) {
        int points = 0;
        int check = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'Q') {
                break;
            }
            if (path.charAt(i) == 'R') {
                posc++;
                if (isValid(posr, posc, arr)) {
                    if (arr[posr][posc] != 0) {
                        check++;
                    }
                    points += arr[posr][posc];
                    points--;
                } else {
                    System.out.println("*** Mission Failed! ***");
                    System.out.println("The maximum points can be collected : " + max);
                    break;
                }
            }
            if (path.charAt(i) == 'L') {
                posc--;
                if (isValid(posr, posc, arr)) {
                    if (arr[posr][posc] != 0) {
                        check++;
                    }
                    points += arr[posr][posc];
                    points--;
                } else {
                    System.out.println("*** Mission Failed! ***");
                    System.out.println("The maximum points can be collected : " + max);
                    break;
                }
            }
            if (path.charAt(i) == 'U') {
                posr--;
                if (isValid(posr, posc, arr)) {
                    if (arr[posr][posc] != 0) {
                        check++;
                    }
                    points += arr[posr][posc];
                    points -= 2;
                } else {
                    System.out.println("*** Mission Failed! ***");
                    System.out.println("The maximum points can be collected : " + max);
                    break;
                }
            }
            if (path.charAt(i) == 'D') {
                posr++;
                if (isValid(posr, posc, arr)) {
                    if (arr[posr][posc] != 0) {
                        check++;
                    }
                    points += arr[posr][posc];
                    points -= 2;
                } else {
                    System.out.println("*** Mission Failed! ***");
                    System.out.println("The maximum points can be collected : " + max);
                    break;
                }
            }
        }
        if (check == cell) {
            System.out.println("*** Mission Passed! ***");
            System.out.println("You have collected maximum points : " + points);
        } else {
            System.out.println("*** Mission Failed! ***");
            System.out.println("The maximum points can be collected : " + max);
        }
    }

    static boolean isValid(int r, int c, int[][] arr) {
        if (r > arr.length || c > arr.length) {
            return false;
        }
        return true;
    }
}