package programmercarl;
//203. 移除链表元素
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = dum;
        while (fast != null) {
            if (fast.val != val) {
                fast = fast.next;
                slow = slow.next;
            } else {
               slow.next = fast.next;
               fast = fast.next;
            }
        }
        return dum.next;
    }
}
