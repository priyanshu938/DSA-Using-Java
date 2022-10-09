public class DiameterofBinaryTree {
    public static int max = Integer.MIN_VALUE;

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
        n3.left = n4;
        n4.left = n5;
        n5.left = n9;
        n3.right = n6;
        n6.right = n7;
        n7.right = n8;
        // diameterBinaryTree(n1);
        diameterBinaryTreeOptimized(n1);
        System.out.println("Diameter of binary tree is : " + max);

    }

    // O(n^2) approach
    private static void diameterBinaryTree(Node root) {
        if (root == null)
            return;
        int lh = heightBinaryTree(root.left);
        int rh = heightBinaryTree(root.right);
        max = Math.max(max, lh + rh);
        diameterBinaryTree(root.left);
        diameterBinaryTree(root.right);
    }

    // O(n) approach
    private static int diameterBinaryTreeOptimized(Node root) {
        if (root == null)
            return 0;
        int lh = diameterBinaryTreeOptimized(root.left);
        int rh = diameterBinaryTreeOptimized(root.right);
        max = Math.max(max, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    private static int heightBinaryTree(Node n1) {
        if (n1 == null)
            return 0;
        int lh = heightBinaryTree(n1.left);
        int rh = heightBinaryTree(n1.right);
        return 1 + Math.max(lh, rh);
    }
}
