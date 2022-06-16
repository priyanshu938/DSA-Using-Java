import java.util.*;

public class DisjointSets {

    static int n = 7, parent[] = new int[n + 1], rank[] = new int[n + 1];

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            /*
             * make set will initialize the parents of nodes to themselves and their ranks
             * to 0.
             */
            makeSet();
            // suppose m union scenarios are given
            int m = scanner.nextInt();
            while (m != 0) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                // perform union for all m scenarios
                union(u, v);
            }
        }
        // To check if 2 and 3 belong to the same component or not
        if (findParent(2) != findParent(3))
            System.out.println("Different Component");
        else
            System.out.println("Same component");

    }

    private static void makeSet() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
        /*
         * directly for compressing path we are assigning value to the
         * parent of node itself at the time of recursive call itself
         */

    }

    private static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);
        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[v] < rank[u])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
}
