import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelBooking {

    static Node removeFirst(Node head, int booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        if (head.data == booking) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data == booking) {
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void printBookings(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {
            int booking = sc.nextInt();

            Node newNode = new Node(booking);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        int cancel = sc.nextInt();

        head = removeFirst(head, cancel);

        printBookings(head);

        sc.close();
    }
}
