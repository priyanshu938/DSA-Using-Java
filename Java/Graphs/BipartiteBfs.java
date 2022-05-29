import java.util.*;

public class BipartiteBfs {

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
            System.out.println(isBipartiteBFS(V, adj));
        }

    }

    private static boolean isBipartiteBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V + 1];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        color[1] = 1;// color first node with color 1
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];// if node is 1 then adjacent will be 0 and vice versa
                    q.offer(it);
                } else if (color[it] == color[node])
                    return false;
            }
        }
        return true;
    }
}