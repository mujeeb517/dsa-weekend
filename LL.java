public class LL {

    // Linear DS
    // arrays, linked list, HashMap, Set, stacks, queues

    // dynamically grow and shrink
    // arrays: fixed size, no shrink

    // design, algorithmic
    // operations
    // addToTail
    // addToHead
    // removeFirst
    // removeLast
    // size O(1)
    // search O(N)
    // remove O(N)

    private ListNode head = null;
    private ListNode tail = null;
    private int count = 0;

    public void addFirst(int x) {
        ListNode node = new ListNode(x);
        if (head == null) {
            /// value types, ref types
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        ++count;
    }

    public void addLast(int x) {
        ListNode node = new ListNode(x);
        if (head == null) head = node;
        else tail.next = node;
        tail = node;
        ++count;
    }

    public void removeFirst() {
        if (head == null) return;
        if (head == tail) {
            tail = tail.next;
        }
        head = head.next;
        --count;
    }

    // O(1)
    public int size() {
        return count;
    }

    public boolean exists(int x) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.value == x) return true;
            temp = temp.next;
        }
        return false;
    }

    public void print() {
//        for(int i=0;i<n;i++)
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.value + " -> ");
        }

        System.out.println();
    }

    public void remove(int x) {
    }

    public void removeLast() {
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}