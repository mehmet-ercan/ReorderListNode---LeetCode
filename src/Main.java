import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        // For Test
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        ListNode head7 = new ListNode(7);
        ListNode head8 = new ListNode(8);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;

        reorderList(head1);

        while (head1.next != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
        System.out.println(head1.val);
    }

    private static void reorderList(ListNode head) {

        if (head.next != null) {
            ListNode end = head, temp, lastOne, headFinal = head;
            List<ListNode> listnodes = new ArrayList<>();

            while (end.next != null) {
                listnodes.add(new ListNode(end.val));
                end = end.next;
            }

            listnodes.add(end);
            short lstSize = (short) listnodes.size(), itrtr = 1;

            temp = new ListNode(listnodes.get(0).val, null);
            headFinal = temp;
            lastOne = temp;


            for (int i = lstSize / 2; i > 0; i--) {
                temp.next = new ListNode(listnodes.get(lstSize - itrtr).val, null);
                temp = temp.next;
                temp.next = new ListNode(listnodes.get(itrtr).val, null);
                lastOne = temp;
                temp = temp.next;
                itrtr++;
            }

            if (lstSize % 2 == 0) {
                lastOne.next = null;
            }

            head.next = headFinal.next;
        }
    }


}