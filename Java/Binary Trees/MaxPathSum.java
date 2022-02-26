public class MaxPathSum {
    public static void main(String[] args) {
        Node n1 = new Node(-10);
        Node n2 = new Node(9);
        Node n3 = new Node(20);
        Node n4 = new Node(15);
        Node n5 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        int[] max = new int[1];

        maxPathSum(n1, max);
        System.out.println("Maximum Path Sum: " + max[0]);
    }

    private static int maxPathSum(Node root, int[] max) {
        if (root == null)
            return 0;
        // ignoring negative sums by taking Max(0,leftSum) and same for right sum
        int leftSum = Math.max(0, maxPathSum(root.left, max));
        int rightSum = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], root.data + leftSum + rightSum);// this will update max variable
        return root.data + Math.max(leftSum, rightSum);// this will process for each node
    }

}
