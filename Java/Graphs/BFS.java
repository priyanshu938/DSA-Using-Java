import java.util.*;

public class BFS {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V = sc.nextInt(), E = sc.nextInt(), i, u, v;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (i = 1; i <= V+1; i++)
                adj.add(new ArrayList<Integer>());

            for (i = 1; i <= E; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            System.out.println(bfsOfGraph(V, adj));
        }

    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];
        ArrayList<Integer> bfs = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);
                    for (Integer it : adj.get(node)) {
                        if (vis[it] == false) {
                            bfs.add(it);
                            vis[it] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }
}