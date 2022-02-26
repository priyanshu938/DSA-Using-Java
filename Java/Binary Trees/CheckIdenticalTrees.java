public class CheckIdenticalTrees {
    public static void main(String[] args) {
        // Tree 1 with root node n1
        Node n1 = new Node(-10);
        Node n2 = new Node(9);
        Node n3 = new Node(20);
        Node n4 = new Node(15);
        Node n5 = new Node(7);
        // Tree 2 with root node N1
        Node N1 = new Node(-10);
        Node N2 = new Node(9);
        Node N3 = new Node(20);
        Node N4 = new Node(15);
        Node N5 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        N1.left = N2;
        N1.right = N3;
        N3.left = N4;
        N3.right = N5;
        System.out.println(checkIdenticalTrees(n1, N1));
    }

    private static boolean checkIdenticalTrees(Node p, Node q) {
        if (p == null || q == null)
            return p == q;
        return p.data == q.data && checkIdenticalTrees(p.left, q.left) && checkIdenticalTrees(p.right, q.right);
    }
}
