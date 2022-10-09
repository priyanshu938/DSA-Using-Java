public class HeightBinaryTree {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.right = n6;
        System.out.println(heightBinaryTree(n1));

    }

    private static int heightBinaryTree(Node n1) {
        if (n1 == null)
            return 0;
        int lh = heightBinaryTree(n1.left);
        int rh = heightBinaryTree(n1.right);
        return 1 + Math.max(lh, rh);
    }
}