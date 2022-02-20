/* Balanced Binary Tree : A binary tree in which the height of the left and right subtree
 of any node differ by not more than 1. */
public class CheckBalancedBinaryTree {
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
        n4.left = n6;
        n4.right = n7;

        System.out.println(checkBalancedBinaryTree(n1));
    }

    private static boolean checkBalancedBinaryTree(Node n1) {
        if (n1 == null)
            return true;
        int lh = heightBinaryTree(n1.left);
        int rh = heightBinaryTree(n1.right);
        if (Math.abs(lh - rh) > 1)
            return false;
        boolean left = checkBalancedBinaryTree(n1.left);
        boolean right = checkBalancedBinaryTree(n1.right);
        return left && right;

    }

    private static int heightBinaryTree(Node n1) {
        if (n1 == null)
            return 0;
        int l = heightBinaryTree(n1.left);
        int r = heightBinaryTree(n1.right);
        return 1 + Math.max(l, r);
    }
}
