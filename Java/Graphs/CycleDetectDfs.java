import java.util.*;

public class CycleDetectDfs {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V = sc.nextInt(), E = sc.nextInt(), i, u, v;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (i = 1; i <= V + 1; i++)
                adj.add(new ArrayList<Integer>());

            for (i = 1; i <= E; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            System.out.println(isCycle(V, adj));
        }

    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(adj, i, -1, vis))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] vis) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                if (checkForCycle(adj, it, node, vis))
                    return true;
            } else if (it != parent)
                return true;
        }
        return false;
    }
}