package medium;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head){
       HashSet<ListNode> list = new HashSet<>();
        ListNode l;
        if (head == null)
            return null;
        else
             l = head;
        while (list.add(l) && l.next != null){
            l = l.next;

        }
        if (l.next != null) return l;
        else return null;
    }
}
