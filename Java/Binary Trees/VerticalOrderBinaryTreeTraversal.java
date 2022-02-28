import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    int hd;
    Node node;

    Pair(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}

public class VerticalOrderBinaryTreeTraversal {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.right = n8;
        n3.left = n6;
        n3.right = n7;
        n6.right = n9;
        verticalOrder(n1);
    }

    /*
     * Approach:
     * 1-Traverse all the nodes in level order using a queue.
     * 2- Add a custom made Pair data structure which contains the height distance
     * hd) and the node data in every node traversal order.
     * 3- Every time check whether the key is present in the map or not,if it is
     * present append the element in the list else put the key-value (here value is
     * a list) in the Tree Map.
     * 4- When the queue is empty, Tree Map;s values will contain the required
     * Vertical Order Traversal.
     */
    private static void verticalOrder(Node root) {
        // Tree Map maintains keys in ascending order
        Map<Integer, List<Integer>> tm = new TreeMap<Integer, List<Integer>>();
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (tm.containsKey(curr.hd)) {
                tm.get(curr.hd).add(curr.node.data);

            } else {
                List<Integer> x = new ArrayList<Integer>();
                x.add(curr.node.data);
                tm.put(curr.hd, x);
            }
            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }
        for (Integer i : tm.keySet()) {
            for (Integer j : tm.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
