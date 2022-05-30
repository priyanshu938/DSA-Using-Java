//Use of Kahn's Algorithm (Refer topological sort using BFS before this problem)
import java.util.*;

public class CycleDetectDirectedGraphBfs {
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
            int[] inDegree = new int[V];
            // for finding indegree of all nodes in a graph
            for (i = 0; i < V; i++) {
                for (Integer it : adj.get(i))
                    inDegree[it]++;
            }

            Queue<Integer> q = new LinkedList<>();
            // Push those nodes in queue whose indegree is 0.
            for (i = 0; i < V; i++) {
                if (inDegree[i] == 0)
                    q.offer(i);
            }
            System.out.println(checkCycleBFS(adj, q, inDegree));
        }

    }

    private static boolean checkCycleBFS(ArrayList<ArrayList<Integer>> adj, Queue<Integer> q, int[] inDegree) {
       int count=0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            count++;
            for (Integer it : adj.get(node)) {
                inDegree[it]--;
                // Push those nodes in queue whose indegree is 0
                if (inDegree[it] == 0)
                    q.offer(it);
            }
        }
        return count != adj.size();
    }
}
