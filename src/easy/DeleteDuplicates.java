package easy;

public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();

    }

    public ListNode deleteDuplicatesMethod(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }

        return head;
    }

    class ListNode {
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
}
