
/**
 * Taru exam is on the head. So she started learning physics. There she learned
 * about Pascal's law. Now she wanted to try an experiment to get a better
 * understanding of the same.
 * 
 * For the experiment Taru has N buckets (numbered from 1,2,3...N) which all are
 * initially empty. She has M number of queries. Each query represents an
 * integer that is of 4 types.
 * 
 * Query 1: Fill all the buckets with water.
 * 
 * Query 2: Empty all even valued buckets (2, 4, 6,...).
 * 
 * • Query 3: Empty all odd number buckets (1, 3, 5,...).
 * 
 * • Query 4: Empty all the buckets. (1,2,3...N).
 * 
 * You have to return the number of buckets that are filled after performing M
 * queries.
 */
import java.util.*;

public class TaruWaterBucketProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of buckets : ");
        int n = scanner.nextInt(), nCopy = n;
        int evenFill = 0, oddFill = 0, M;

        System.out.println("Enter number of queries :");
        M = scanner.nextInt();
        List<Integer> queries = new LinkedList<Integer>();
        System.out.println("Enter queries array:");
        for (int i = 1; i <= M; i++)
            queries.add(scanner.nextInt());
        scanner.close();
        for (Integer i : queries) {
            if (i == 1) {
                n = nCopy;
                evenFill = 0;
                oddFill = 0;
            } else if (i == 2) {
                if (evenFill == 0 && oddFill == 0) {
                    n = n / 2;
                    evenFill = 1;
                    oddFill = 0;
                }
                if (evenFill == 0 && oddFill == 1) {
                    n = 0;
                }
            } else if (i == 3) {
                if (oddFill == 0 && evenFill == 0) {
                    n = n / 2;
                    oddFill = 1;
                    evenFill = 0;
                }
                if (evenFill == 1 && oddFill == 0) {
                    n = 0;
                }
            } else
                n = 0;
        }
        System.out.println("The number of buckets that are filled after performing given queries are :" + n);
    }
}