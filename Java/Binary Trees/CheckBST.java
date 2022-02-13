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

public class CheckBST {
    public static ArrayList<Integer> li = new ArrayList<Integer>();

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(20);
        Node n3 = new Node(10);
        Node n4 = new Node(25);
        Node n5 = new Node(45);
        Node n6 = new Node(50);
        Node n7 = new Node(47);
        root.left = n2;
        root.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        n6.left = n7;
        /*
         * Inorder traversal of a BST gives a sorted list, so we will find the inorder
         * traversal of the tree and after getting the inorder traversal of the tree if
         * its not sorted then we
         * will print NOo else YES
         */
        inorder(root);
        System.out.println(li);
        int k = -1;
        for (int i = 0; i < li.size() - 1; i++) {
            if (li.get(i) < li.get(i + 1)) {
            } else {
                System.out.println("No");
                k = 1;
                break;

            }
        }
        if (k == -1)
            System.out.println("Yes");

    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        li.add(root.data);
        inorder(root.right);

    }

}
