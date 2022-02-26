import java.util.*;

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
        int flag=0;
        if (root == null)
            return ds;
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for (int i = 0; i < level; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                if (flag == 0) {
                    sublist.add(q.pollFirst().data);
                } else {
                    sublist.add(q.pollLast().data);
                }
            }
            if (flag == 0)
                flag = 1;
            else
                flag = 0;
            ds.add(sublist);
        }
        return ds;

    }

}
