import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int key) {
        data = key;
        left = null;
        right = null;
    }
}

public class ZigZagTraversal {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(zigZagTraversal(n1));
    }

    private static List<List<Integer>> zigZagTraversal(Node root) {
        ArrayDeque<Node> q = new ArrayDeque<Node>();
        List<List<Integer>> ds = new LinkedList<List<Integer>>();
        int flag = 0;
        if (root == null)
            return ds;
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for (int i = 0; i < level; i++) {
                Node x = q.poll();
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
                sublist.add(x.data);
            }
            if (flag == 0) {
                ds.add(sublist);
                flag = 1;
            } else {
                Collections.reverse(sublist);
                ds.add(sublist);
                flag = 0;
            }
        }
        return ds;

    }

}
