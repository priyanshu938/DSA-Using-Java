import java.util.*;

public class CycleDetectDirectedGraphDfs {
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
            }

            System.out.println(isCycle(V, adj));
        }

    }

    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V + 1];
        int[] dfsVis = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (vis[i] == 0)
                if (checkCycleInDirectedGraphDFS(adj, vis, dfsVis, i))
                    return true;
        }
        return false;
    }

    private static boolean checkCycleInDirectedGraphDFS(ArrayList<ArrayList<Integer>> adj, int[] vis,
            int[] dfsVis, int node) {
        vis[node] = 1;
        dfsVis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                if (checkCycleInDirectedGraphDFS(adj, vis, dfsVis, it))
                    return true;
            } else if (dfsVis[it] == 1)
                return true;
        }
        dfsVis[node] = 0;
        return false;
    }
}
