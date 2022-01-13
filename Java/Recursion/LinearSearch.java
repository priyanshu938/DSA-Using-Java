

import java.util.ArrayList;

public class LinearSearch {
    public static boolean linearSearch(int[] a, int i, int f) {
        if (i == a.length)
            return false;
        else {
            return a[i] == f || linearSearch(a, i + 1, f);
        }

    }

    public static ArrayList<Integer> linearSearchAllOccurences(int[] a, int i, int f, ArrayList<Integer> list) {
        if (i == a.length - 1)
            return list;
        if (a[i] == f)
            list.add(i);
        return linearSearchAllOccurences(a, i + 1, f, list);

    }

    public static void main(String[] args) {
        int[] a = { 8, 1, 4, 56, 78, 8, 9 };
        int f = 8;
        System.out.println(linearSearch(a, 0, f));
        System.out.println(linearSearchAllOccurences(a, 0, f, new ArrayList<Integer>()));

    }

}
