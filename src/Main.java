
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

        //For Debug

//        ListNode head0 = new ListNode(0);
//        ListNode head1 = new ListNode(1);
//        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);
//        ListNode head6 = new ListNode(6);

        // For Test
        ListNode head0 = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(6);
        ListNode head6 = new ListNode(7);


        head0.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;

        reorderList(head0);

        while (head0.next != null) {
            System.out.println(head0.val + " ");
            head0 = head0.next;

            if (head0.next == null) {
                System.out.println(head0.val + " ");
            }
        }
    }

    public static void reorderList(ListNode head) {
        if (head.next != null) {

            int length = 2;
            ListNode start = head.next;

            ListNode neww = head;
            neww.val = head.val;

            ListNode end = start;

            while (end.next != null) {
                length++;
                end = end.next;
            }

            while (start != end) {
                ListNode adding = new ListNode(end.val, null);
                neww.next = adding;
                neww = neww.next;

                adding = new ListNode(start.val, null);
                neww.next = adding;
                neww = neww.next;

                start = start.next;

                if (start == end) {
                    break;
                }

                ListNode temp = start;
                while (temp.next != end) {
                    temp = temp.next;
                }

                end = temp;
                end.next = null;
            }
            
            if (length % 2 == 0) {
                neww.next = start;
            }
        }
    }
}