public class LinkedLists {

    // print list in reverse order
    public static void printReverse(ListNode head) {
        if (head == null) return;

        System.out.print(head.value +" -> ");
        printReverse(head.next);
    }
}
