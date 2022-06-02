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

public class PrimsAlgorithm {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int V = scanner.nextInt(), E = scanner.nextInt(), i, u, v, w;
            ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
            for (i = 0; i <= V; i++)
                adj.add(new ArrayList<Pair>());

            for (i = 1; i <= E; i++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                w = scanner.nextInt();
                adj.get(u).add(new Pair(v, w));
            }
            primAlgo(V, adj);
        }

    }

    private static void primAlgo(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] key = new int[V], parent = new int[V];
        boolean mst[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }
        key[0] = 0;
        //looping form 0 to V-1 as MST has N nodes and N-1 edges
        for (int i = 0; i < V - 1; i++) {
            int min = Integer.MAX_VALUE, u = 0;// u for finding the position of minimum node among the key array
            for (int v = 0; v < V; v++) {
                if (mst[v] == false && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }
            mst[u] = true;
            //Traversing through the adjacent edges of minimum node u.
            for (Pair it : adj.get(u)) {
                if (mst[it.getV()] == false && it.getW() < key[it.getV()]) {
                    key[it.getV()] = it.getW();
                    parent[it.getV()] = u;
                }

            }
        }
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i);// node1 will connect to node2,i.e., node1 -- node2

    }

}
