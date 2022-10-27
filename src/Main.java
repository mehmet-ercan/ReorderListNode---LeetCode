public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode head0 = new ListNode(0);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head0.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        reorderList(head0);

        while (head0.next != null) {
            System.out.println(head0.val + " ");
            head0 = head1.next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head.next != null) {
            ListNode start = head.next;
            ListNode end = getLastNode(head);
            ListNode tempHead = head;

            while (start != end) {
                if (start.next == end) {
                    break;
                }

                tempHead.next = end;
                end.next = start;
                tempHead = tempHead.next;
                tempHead = tempHead.next;
                start = start.next;
                end = getLastNode(start);

            }
        }
    }

    public static ListNode getLastNode(ListNode l) {
        ListNode btl = l;

        while (l.next != null) {
            btl = l;
            l = l.next;
        }

        btl.next = null;
        return l;
    }

}