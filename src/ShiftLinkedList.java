public class ShiftLinkedList {

    private ListNode shift(ListNode head, int k) {
        ListNode current = head;
        ListNode newTail = null;
        int len = listLength(head);

        ListNode tail = head;

        int counter = 0;
        while (current != null) {
            tail = current;
            current = current.next;

            counter++;

            if (counter == len - k - 1) {
                newTail = current;
            }
        }

        tail.next = head;
        head = newTail.next;
        newTail.next = null;

        return head;
    }

    private int listLength(ListNode head) {
        ListNode current = head;
        int len = 0;

        while (current != null) {
            current = current.next;
            len++;
        }

        return len;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ShiftLinkedList shiftLinkedList = new ShiftLinkedList();


        System.out.println("Original linked list:");
        shiftLinkedList.printList(head);

        // Reverse the linked list
        ListNode reversedHead = shiftLinkedList.shift(head, 5);

        System.out.println("\nReversed linked list:");
        shiftLinkedList.printList(reversedHead);
    }
}