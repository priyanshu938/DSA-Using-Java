//Dijkstra's algorithm
import java.util.*;

class Node implements Comparator<Node> {
    private int v, w;
//Constructor 1
    Node() {
    }
//Constructor 2
    Node(int v, int w) {
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
    public int compare(Node n1, Node n2) {
        if (n1.w < n2.w)
            return -1;
        if (n1.w > n2.w)
            return 1;
        return 0;

    }
}

public class ShortestPathUndirectedWeightedGraph {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int V = scanner.nextInt();
            int E = scanner.nextInt(), u, v, w, i;
            ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
            for (i = 1; i <= V + 1; i++) {
                adj.add(new ArrayList<Node>());
            }
            for (i = 1; i <= E; i++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                w = scanner.nextInt();
                adj.get(u).add(new Node(v, w));
                adj.get(v).add(new Node(u, w));
            }
            shortestPathUndirectedWeightedGraph(0, adj, V);
            scanner.close();
        }
    }

    private static void shortestPathUndirectedWeightedGraph(int src, ArrayList<ArrayList<Node>> adj, int V) {
        int[] dis = new int[V + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());// size of PQ is V and type is Node
        pq.offer(new Node(src, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node it : adj.get(node.getV())) {
                if (dis[node.getV()] + it.getW() < dis[it.getV()]) {
                    dis[it.getV()] = dis[node.getV()] + it.getW();
                    pq.add(new Node(it.getV(), dis[it.getV()]));
                }
            }
        }
        for (int it : dis) {
            System.out.print(it + " ");
        }
    }
}
