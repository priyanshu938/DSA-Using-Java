
/**
 * Taru's exam is on the head. So she started learning physics. There she learned
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
 * Query 3: Empty all odd number buckets (1, 3, 5,...).
 * 
 * Query 4: Empty all the buckets. (1,2,3...N).
 * 
 * You have to return the number of buckets that are filled after performing M
 * queries.
 */
import java.util.*;

public class TaruWaterBucketProblemSecondApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of buckets : ");
        int n = scanner.nextInt();
        System.out.println("Enter number of queries :");
        int M = scanner.nextInt();
        List<Integer> queries = new LinkedList<Integer>();
        System.out.println("Enter queries array:");
        for (int i = 1; i <= M; i++)
            queries.add(scanner.nextInt());
        scanner.close();
        int ans = buckets(queries, n);
        System.out.println("The number of buckets that are filled after performing given queries are : " + ans);

    }

    public static int buckets(List<Integer> m, int n) {

        List<Integer> list = new ArrayList<>();
        list.add(m.get(0));
        for (int i = 1; i < m.size(); i++) {
            if (m.get(i) != m.get(i - 1))
                list.add(m.get(i));
        }
        if (!list.contains(1))
            return 0;
        if (list.size() == 1) {
            int x = list.get(0);
            if (x == 1)
                return n;
            return 0;
        }
        if (list.get(list.size() - 1) == 1)
            return n;

        if (list.get(list.size() - 1) == 4)
            return 0;

        if (list.get(list.size() - 1) == 3) {
            if (list.get(list.size() - 2) == 2 || list.get(list.size() - 2) == 4)
                return 0;
            else
                return n / 2;
        }
        if (list.get(list.size() - 1) == 2) {
            if (list.get(list.size() - 2) == 3 || list.get(list.size() - 2) == 4)
                return 0;
            else
                return n % 2 == 0 ? n / 2 : n / 2 + 1;
        }
        return 0;
    }
}