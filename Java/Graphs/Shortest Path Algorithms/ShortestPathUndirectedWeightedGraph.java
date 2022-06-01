
//Dijkstra's algorithm
/* 
We can implement the algorithm using the following steps:
1) We would be using a min-heap and a distance array of size N initialized with infinity (indicating that at present none of the nodes are reachable from the source node) and initialize the distance to source node as 0.
2) We push the source node to the queue.
3) For every node at the top of the queue we pop that element out and look out for its adjacent nodes. If the current reachable distance is better than the previous distance indicated by the distance array, we update the distance and push it in the queue.
4) A node with a lower distance would be at the top of the priority queue as opposed to a node with a higher distance. By following the steps 3, until our queue becomes empty, we would get the minimum distance from the source node to all other nodes. Here’s a quick demonstration of the same.
*/
import java.util.*;

class Node implements Comparator<Node> {
    private int v, w;

    // Constructor 1
    Node() {
    }

    // Constructor 2
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
            for (i = 0; i <= V; i++) {
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
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Node());
        /*
         * new Node() declares a custom comparator that was built in Node class, i.e.,
         * converting the priority queue to a min-Heap priority queue.
         */
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
