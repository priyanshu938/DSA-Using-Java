

public class RotatedBinarySearch {
    public static int rotatedBinarySearch(int[] a, int f, int s, int e) {
        if (s > e)
            return -1;
        int m = (s + e) / 2;
        if (a[m] == f)
            return m;
        if (f >= a[s] && f < a[m])
            return rotatedBinarySearch(a, f, s, m - 1);
        else
            return rotatedBinarySearch(a, f, m + 1, e);
    }

    public static void main(String[] args) {
        int[] a = { 1, 12, 33, 34, 50, 61, 75, 80, 99 };
        int f = 33;
        System.out.println(rotatedBinarySearch(a, f, 0, a.length - 1));
    }
}