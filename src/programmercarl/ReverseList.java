package programmercarl;
//206. 反转链表
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode curr = null;
        ListNode pre = head;
        while (pre.next != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        pre.next = curr;
        return pre;


    }
}
