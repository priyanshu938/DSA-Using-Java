import java.util.*;

public class BottomViewOfBinaryTree {
    public static Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();

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
        /*
         * Approach:
         * 1-Perform the vertical order traversal.
         * 2-The last element of the list in the vertical order traversal will be the
         * Bottom View of the Binary Tree.
         */
        System.out.println("Bottom View of the given binary tree is :");
        verticalOrder(n1);
        for (Integer i : tm.keySet()) {
            System.out.print(tm.get(i) + " ");
        }
    }

    private static void verticalOrder(Node root) {
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            /*
             * Adding the Key-Value in the Tree Map if it is not presnted already,and if its
             * is present we want the latest value , so simply by below statement it will
             * update the Tree Map accordingly.
             */
            tm.put(curr.hd, curr.node.data);
            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }
    }
}
