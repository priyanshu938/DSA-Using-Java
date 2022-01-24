import java.util.Arrays;

public class BubbleSortRecursion {
    public static void bubbleSortRecursion(int[] a, int r, int c) {
        if (r == 0)
            return;
        if (c < r) {
            if (a[c] > a[c + 1]) {
                int t = a[c];
                a[c] = a[c + 1];
                a[c + 1] = t;
            }
            bubbleSortRecursion(a, r, c + 1);
        } else {

            bubbleSortRecursion(a, r - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = { 3, 2, 1, 6, 4 };
        bubbleSortRecursion(a, a.length - 1, 0);
        System.out.println(Arrays.toString(a));
    }

}