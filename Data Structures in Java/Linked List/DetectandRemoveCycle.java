class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
    }
}

public class DetectandRemoveCycle {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n3;

        Node f = n1;
        Node s = n1;
        int k = -1;
        // check cycle
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                System.out.println("Cycle present");
                k = 1;
                break;
            }
        }
        if (k == -1)
            System.out.println("Cycle not present");

        // find starting node of cycle
        Node temp = s, curr = n1, prev = temp;
        while (temp != curr) {
            prev = temp;
            curr = curr.next;
            temp = temp.next;

        }

        // removing cycles from linked List
        prev.next = null;
        // printing linked list after removing cycles from linked List
        display(n1);

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