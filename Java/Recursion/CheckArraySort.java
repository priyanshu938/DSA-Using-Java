import java.util.*;
public class CheckArraySort {
    public static boolean checkArraySort(List<Integer> list, int i) {

        if (i == list.size() - 1)
            return true;
        return list.get(i) < list.get(i + 1) && checkArraySort(list, i + 1);

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(8);
        System.out.println(checkArraySort(list, 0));

    }
}