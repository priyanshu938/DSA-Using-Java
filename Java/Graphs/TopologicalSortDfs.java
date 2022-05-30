import java.util.*;

public class TopologicalSortDfs {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V = sc.nextInt(), E = sc.nextInt(), i, u, v;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());

            for (i = 1; i <= E; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                adj.get(u).add(v);
            }
            int[] vis = new int[V];
            Arrays.fill(vis, 0);
            Stack<Integer> stack = new Stack<>();

            for (i = 0; i < V; i++) {
                if (vis[i] == 0)
                    topoSortDfs(i, adj, vis, stack);
            }
            Collections.reverse(stack);
            System.out.println("Required topological sort for the given graph is : " + stack);
        }

    }

    private static void topoSortDfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[i] = 1;
        for (Integer it : adj.get(i)) {
            if (vis[it] == 0) {
                vis[it] = 1;
                topoSortDfs(it, adj, vis, stack);
            }
        }
        stack.push(i);
    }
}
