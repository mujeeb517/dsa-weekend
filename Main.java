import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        // 0->1->2->3->4->5

        LinkedLists.printReverse(head);
    }
}
