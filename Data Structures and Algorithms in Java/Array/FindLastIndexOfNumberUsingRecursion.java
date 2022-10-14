public class FindLastIndexOfNumberUsingRecursion {
    public static void main(String[] args) {
        int ar[] = { 1, 2, 4, 4, 5 };
        int Index = find(ar, 4);
        System.out.println(Index);
    }

    public static int find(int[] ar, int a) {
        int Index = find(ar, a, 0);
        return Index;
    }

    private static int find(int[] ar, int a, int Start) {
        int length = ar.length;
        if (Start == length) {
            return -1;
        }
        int result = find(ar, a, Start + 1);
        if (result != -1) {
            return result;
        }
        if (ar[Start] == a)
            return Start;
        else
            return result;
    }
}
