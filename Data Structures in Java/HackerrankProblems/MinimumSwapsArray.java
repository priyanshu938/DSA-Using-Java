import java.util.*;
import java.io.*;

public class MinimumSwapsArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = br.readLine();
        String[] arr = s.split(" ");
        int[] a = new int[n + 1];
        a[0] = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            a[i + 1] = Integer.valueOf(arr[i]);
        }
        int count = 0;

        for (i = 1; i < a.length; i++) {
            while (a[i] != i) {
                int temp = a[i];
                int x = a[i];
                a[i] = a[x];
                a[x] = temp;
                count++;
            }
        }
        System.out.println(count);
    }
}
