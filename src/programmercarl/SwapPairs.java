package programmercarl;
//24. 两两交换链表中的节点
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode curr = dump;
        ListNode first;
        ListNode second;
        ListNode temp;
        while (curr.next != null && curr.next.next != null) {
            temp = curr.next.next.next;
            first = curr.next;
            second = curr.next.next;

            curr.next = second;
            second.next = first;
            first.next = temp;

            curr = first;

        }
        return dump.next;

    }



}
