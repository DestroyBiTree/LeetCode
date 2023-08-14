package programmercarl;

import java.util.HashSet;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while (!set.contains(curr)) {
            set.add(curr);
            curr = curr.next;
            if (curr == null) {
                break;
            }
        }
        if (curr == null) {
            return null;
        }
        return curr;

    }
}
