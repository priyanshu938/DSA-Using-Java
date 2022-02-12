class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
    }
}

public class MergePointOfTwoLinkedList {
    public static void main(String[] args) {
        // First List
        Node m1 = new Node(1), head1 = m1;
        Node m2 = new Node(2);
        Node m3 = new Node(8);
        Node m4 = new Node(7);
        Node m5 = new Node(6);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = null;
        System.out.println("First List is: ");
        display(head1);
        // Second List
        Node n1 = new Node(2), head2 = n1;
        Node n2 = new Node(8);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = m3;
        Node n6 = m4;
        Node n7 = m5;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = m3;
        System.out.println("Second List is: ");
        display(head2);
        // System.out.println("Merge point of two lists is : " +
        // mergePointBruteForce(head1, head2));
        // System.out.println("Merge point of two lists is : " +
        // mergePointOptimized1(head1, head2));
        System.out.println("Merge point of two lists is : " + mergePointOptimized2(head1, head2).data);

    }

    private static Node mergePointOptimized2(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;
        Node d1 = head1, d2 = head2;

        /*
         * if d1 and d2 have different lengths, then we will stop the loop after second
         * iteration
         */
        while (d1 != d2) {
            /*
             * for the end of the first iteration, we just reset the pointer to the head of
             * other linked list
             */
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }
        return d1;
    }

    private static int mergePointOptimized1(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;
        int l1 = 0, l2 = 0, diff, i;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null) {
                l1++;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                l2++;
                temp2 = temp2.next;
            }
        }
        temp1 = head1;
        temp2 = head2;
        diff = l1 > l2 ? (l1 - l2) : (l2 - l1);
        if (l1 > l2) {
            for (i = 0; i <= diff; i++) {
                temp1 = temp1.next;
            }
            return (int) temp1.next.data;
        } else {
            for (i = 0; i <= diff; i++) {
                temp2 = temp2.next;
            }
            return (int) temp2.next.data;
        }

    }

    private static int mergePointBruteForce(Node head1, Node head2) {
        for (Node i = head1; i != null; i = i.next) {
            for (Node j = head2; j != null; j = j.next) {
                if (i == j)
                    return (int) i.data;
            }
        }
        return -1;
    }

    private static void display(Node n1) {
        if (n1 == null) {
            System.out.println("NULL");
            return;
        }
        System.out.print(n1.data + " -> ");
        display(n1.next);

    }

}