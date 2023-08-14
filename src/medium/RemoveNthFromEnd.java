package medium;
//19. 删除链表的倒数第 N 个结点
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head,q = head;
        for (int i = 0; i < n; i++){
            q = q.next;
        }
        if (q == null)
            return head.next;
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;

    }
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;


    }
}
