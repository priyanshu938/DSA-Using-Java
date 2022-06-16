import java.util.*;

class Node {
    private int u, v, wt;

    public Node(int _u, int _v, int _wt) {
        u = _u;
        v = _v;
        wt = _wt;
    }

    public Node() {
    }

    int getV() {
        return v;
    }

    int getU() {
        return u;
    }

    int getWt() {
        return wt;
    }
}

class SortComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        if (n1.getWt() < n2.getWt())
            return -1;
        if (n1.getWt() > n2.getWt())
            return 1;
        return 0;
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {

        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));
        kruskalAlgorithm(adj, n);
    }

    private static void kruskalAlgorithm(ArrayList<Node> adj, int n) {
        // first sort the nodes according to edge weights.
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[n], rank[] = new int[n];
        // initialize with default values
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int costMst = 0;// to store cost of mst
        ArrayList<Node> mst = new ArrayList<Node>();// to store nodes in mst
        for (Node it : adj) {
            /*
             * check whether both u and v belong to different component or not,if yes then add them in
             * mst and perform union of them (if parent of both the nodes are same that
             * means they are in same component)
             */
            if (findParent(it.getU(), parent) != findParent(it.getV(), parent)) {
                costMst += it.getWt();
                mst.add(it);
                union(it.getU(), it.getV(), parent, rank);
            }
        }
        System.out.println(costMst);
        for (Node it : mst)
            System.out.println(it.getU() + " " + it.getV());

    }

    private static int findParent(int node, int[] parent) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node], parent);

    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);
        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[v] < rank[u])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

}
