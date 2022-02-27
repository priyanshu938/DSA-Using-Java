public class InvertABinaryTree {
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
        System.out.println("Inorder traversal of given binary tree before inversion is :");
        inorder(n1);
        invertBinaryTree(n1);// invert a binary tree means showing the mirror image of that tree.
        System.out.println("\nInorder traversal of given binary tree after inversion is :");
        inorder(n1);
    }

    private static Node invertBinaryTree(Node root) {
        if (root == null)
            return root;
        Node left = invertBinaryTree(root.left); // taking left node
        Node right = invertBinaryTree(root.right);// taking right node
        // Swap left and right node
        root.left = right;
        root.right = left;
        return root;
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}
