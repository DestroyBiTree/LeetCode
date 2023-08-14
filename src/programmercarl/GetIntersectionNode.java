package programmercarl;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode searchA ;
        searchA = headA;
        int alength = 1;
        ListNode searchB;
        searchB = headB;
        int blength = 1;
        while (searchA.next != null) {
            searchA = searchA.next;
            alength++;
        }
        while (searchB.next != null) {
            searchB = searchB.next;
            blength++;
        }
        searchA = headA;
        searchB = headB;

        if (alength > blength) {
            for (int i = 0; i < alength - blength; i++) {
                searchA = searchA.next;
            }
        }
        else {
            for (int i = 0; i < blength - alength; i++) {
                searchB = searchB.next;
            }
        }
        while (searchA != searchB && searchA != null) {
                searchA = searchA.next;
                searchB = searchB.next;
        }
        return searchA;

    }
}