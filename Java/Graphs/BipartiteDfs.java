import java.util.*;

public class BipartiteDfs {
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
            int color[] = new int[V + 1];
            Arrays.fill(color, -1);
            color[1] = 1;// color first node with color 1
            System.out.println(isBipartiteDFS(adj, color, 1));
        }

    }

    private static boolean isBipartiteDFS(ArrayList<ArrayList<Integer>> adj, int color[], int node) {
        for (Integer it : adj.get(node)) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                return isBipartiteDFS(adj, color, it);
            } else if (color[it] == color[node])
                return false;
        }
        return true;
    }
}