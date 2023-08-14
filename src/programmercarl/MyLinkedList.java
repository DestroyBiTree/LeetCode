package programmercarl;
class MyLinkedNode{
    int val;
    MyLinkedNode next;
    MyLinkedNode(){}
    MyLinkedNode(int val){
         this.val = val;
    }

}
public class MyLinkedList {
    MyLinkedNode head;
    //链表的长度
    int size = 0;
    public MyLinkedList() {
        head = new MyLinkedNode(0);
    }

    public int get(int index) {
        int i = 0;
        MyLinkedNode temp = head;
        if (index >= size || index < 0) {
            return -1;
        }
        while (i != index) {
            temp = temp.next;
            i++;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        MyLinkedNode first = new MyLinkedNode(val);
        first.next = head;
        head = first;
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        MyLinkedNode newNode = new MyLinkedNode(val);
        MyLinkedNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) {
            return;
        }
        MyLinkedNode dum = new MyLinkedNode(1001);
        dum.next = head;
        MyLinkedNode temp = head;
        if (index == 0) {
            dum.next = head.next;
            head = dum.next;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;

    }
}
