import java.util.*;

class Pair {
    int v, w;

    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }

    int getV() {
        return v;
    }

    int getW() {
        return w;
    }
}

public class ShortestPathInWeightedDAG {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int V = scanner.nextInt();
            int E = scanner.nextInt(), u, v, w, i;
            ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
            for (i = 0; i < V; i++) {
                adj.add(new ArrayList<Pair>());
            }
            for (i = 1; i <= E; i++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                w = scanner.nextInt();
                adj.get(u).add(new Pair(v, w));
            }
            int[] dis = new int[V];
            int[] vis = new int[V];
            Arrays.fill(dis, Integer.MAX_VALUE);
            Stack<Integer> stack = new Stack<Integer>();
            for (i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    topoSortDfs(i, adj, vis, stack);
                }
            }
            shotestDistanceUndirectedGraphWithUnitWt(adj, stack, dis);
            for (int it : dis) {
                System.out.print(it + " ");
            }
            scanner.close();
        }

    }

    public static void topoSortDfs(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;
        for (Pair it : adj.get(node)) {
            if (vis[it.getV()] == 0) {
                vis[it.getV()] = 1;
                topoSortDfs(it.getV(), adj, vis, stack);
            }
        }
        stack.push(node);
    }

    private static void shotestDistanceUndirectedGraphWithUnitWt(ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack,
            int[] dis) {
        dis[0] = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (Pair it : adj.get(node)) {
                if (dis[node] + it.getW() < dis[it.getV()]) {
                    dis[it.getV()] = dis[node] + it.getW();
                }
            }
        }
    }
}