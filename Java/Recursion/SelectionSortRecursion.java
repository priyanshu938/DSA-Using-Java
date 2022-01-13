

import java.util.Arrays;

public class SelectionSortRecursion {

    private static void selectionSortRecursion(int[] a, int r, int c, int max) {
        if (r == 0)
            return;
        if (c < r) {
            if (a[c] > a[max])
                selectionSortRecursion(a, r, c + 1, c);
            else
                selectionSortRecursion(a, r, c + 1, max);
        } else {

            int t = a[max];
            a[max] = a[r - 1];
            a[r - 1] = t;
            selectionSortRecursion(a, r - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = { 3, 2, 1, 6, 4 };
        selectionSortRecursion(a, a.length, 0, 0);
        System.out.println(Arrays.toString(a));
    }
}
