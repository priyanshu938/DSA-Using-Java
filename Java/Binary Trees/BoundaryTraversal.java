import java.util.*;

public class BoundaryTraversal {
    public static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

    public static void main(String[] args) {
        Node n1 = new Node(20);
        Node n2 = new Node(8);
        Node n3 = new Node(22);
        Node n4 = new Node(4);
        Node n5 = new Node(12);
        Node n6 = new Node(25);
        Node n7 = new Node(10);
        Node n8 = new Node(14);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.left = n7;
        n5.right = n8;

        boundaryTraversal(n1);
        System.out.println(dq);
    }

    private static void boundaryTraversal(Node root) {
        dq.add(root.data);
        if (root.left != null) // left boundary elements
            leftBoundary(root.left);
        leafNodes(root); // leave nodes
        if (root.right != null)
            rightBoundary(root.right);// right boundary elements in reverse order
    }

    private static void leftBoundary(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        dq.add(root.data);
        if (root.left != null)
            leftBoundary(root.left);
        else if (root.right != null)
            leftBoundary(root.right);
    }

    private static void leafNodes(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            dq.add(root.data);
            return;
        }
        leafNodes(root.left);
        leafNodes(root.right);
    }

    private static void rightBoundary(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null)
            rightBoundary(root.left);
        else if (root.right != null)
            rightBoundary(root.right);
        dq.add(root.data);// for reverse order we are adding elements after the recursion calls
    }

}