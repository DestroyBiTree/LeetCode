package medium;

public class SortList {
    public static void main(String[] args) {

    }

    public ListNode sortListMethod(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortListMethod(head);
        ListNode right = sortListMethod(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null){
            if (left.val < right.val){
                h.next = left;
                left = left.next;
            }
            else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

    }
}
