import java.util.*;

class Pair implements Comparator<Pair> {
    int v, w;

    // Constructor1
    Pair() {
    }

    // Constructor2
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

    // This comparator automatically sorts according to the minimal edge weight
    @Override
    public int compare(Pair n1, Pair n2) {
        if (n1.w < n2.w)
            return -1;
        if (n1.w > n2.w)
            return 1;
        return 0;

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
            // primAlgoBruteForceON2(V, adj);
            primAlgoOptimizedNlogN(V, adj);
        }
    }

    // In optimized approach we maintain a min heap PriorityQueue so that we need
    // not to find minimum by traversing whole of the array
    private static void primAlgoOptimizedNlogN(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] key = new int[V], parent = new int[V];
        boolean mst[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }
        key[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Pair());
        pq.add(new Pair(0, key[0]));
        // looping form 0 to V-1 as MST has N nodes and N-1 edges
        for (int i = 0; i < V - 1; i++) {
            int u = pq.poll().getV();
            mst[u] = true;
            // Traversing through the adjacent edges of minimum node u.
            for (Pair it : adj.get(u)) {
                if (mst[it.getV()] == false && it.getW() < key[it.getV()]) {
                    key[it.getV()] = it.getW();
                    parent[it.getV()] = u;
                    pq.add(new Pair(it.getV(), key[it.getV()]));
                }
            }
        }
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i);// node1 will connect to node2,i.e., node1 -- node2

    }

    private static void primAlgoBruteForceON2(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] key = new int[V], parent = new int[V];
        boolean mst[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }
        key[0] = 0;
        // looping form 0 to V-1 as MST has N nodes and N-1 edges
        for (int i = 0; i < V - 1; i++) {
            int min = Integer.MAX_VALUE, u = 0;// u for finding the position of minimum node among the key array
            for (int v = 0; v < V; v++) {
                if (mst[v] == false && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }
            mst[u] = true;
            // Traversing through the adjacent edges of minimum node u.
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
