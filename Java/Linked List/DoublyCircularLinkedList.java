class Node<T> {
    Node prev;
    T data;
    Node next;

    Node(T data) {
        this.data = data;
    }
}

public class DoublyCircularLinkedList {

    public static Node head, tail;

    public static void insert(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            head.prev = tail;
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;

    }

    private static void delete(int pos) {
        Node temp = head;
        if (pos == 0) {
            head = head.next;
            head.prev = tail;
        }
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;

    }

    public static void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(7);
        Node n4 = new Node(8);
        Node n5 = new Node(9);
        n1.prev = null;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = head;
        head = n1;
        tail = n5;
        System.out.println("Linked list is : ");
        traverse();
        insert(10, 4);
        System.out.println("Linked list after insertion is : ");
        traverse();
        delete(3);
        System.out.println("Linked list after deletion is : ");
        traverse();
    }

}