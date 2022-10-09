import java.util.*;
class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


public class CycleDetectBfs {

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
                if (checkForCycle(adj, i, vis))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, -1));
        vis[s] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int curr = node.first;
            int par = node.second;
            for (Integer it : adj.get(curr)) {
                if (vis[it] == false) {
                    q.add(new Node(it, curr));
                    vis[it] = true;
                } else if (par != it)
                    return true;
            }
        }
        return false;
    }
}