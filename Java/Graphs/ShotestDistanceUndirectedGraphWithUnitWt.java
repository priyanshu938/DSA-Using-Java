import java.util.*;

public class ShotestDistanceUndirectedGraphWithUnitWt {
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
                adj.get(v).add(u);
            }
            int[] dis = new int[V];
            Arrays.fill(dis, Integer.MAX_VALUE);
            Queue<Integer> q = new LinkedList<Integer>();

            shotestDistanceUndirectedGraphWithUnitWt(0, adj, q, dis);
            for (int it : dis) {
                System.out.print(it + " ");
            }
        }

    }

    private static void shotestDistanceUndirectedGraphWithUnitWt(int source, ArrayList<ArrayList<Integer>> adj,
            Queue<Integer> q, int[] dis) {
        q.offer(source);
        dis[source] = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer it : adj.get(node)) {
                if (dis[node] + 1 < dis[it]) {
                    dis[it] = dis[node] + 1;
                    q.offer(it);//if update the distance then put it in the queue.
                }
            }
        }
    }
}
