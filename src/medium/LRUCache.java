package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//146. LRU 缓存
public class LRUCache {
    int capacity;
    Map<Integer, LinkNode> map = new HashMap<>();
    LinkNode head = new LinkNode(0,0);
    LinkNode tail = new LinkNode(0,0);
    public LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.front = head;

    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else  {
            LinkNode temp = map.get(key);
            temp.next.front = temp.front;
            temp.front.next = temp.next;
            addNode(temp);
            return temp.value;
        }

    }

    public void put(int key, int value) {
        if (!map.containsKey(key)){
            if (map.size() == capacity){
                deleteLastNode();
            }
            LinkNode temp = new LinkNode(key, value);
            addNode(temp);
        }
        else {
            LinkNode temp = map.get(key);
            //断掉原来的链表
            temp.next.front = temp.front;
            temp.front.next = temp.next;
//            temp.next = null;
//            temp.front = null;
            //赋新值 再加入到头结点
            temp.value = value;
            addNode(temp);
        }
    }

    private void addNode(LinkNode node) {
        LinkNode temp = head.next;
        head.next = node;
        temp.front = node;
        node.next = temp;
        node.front = head;
        map.put(node.key, node);
    }

    private void deleteLastNode() {
        LinkNode temp = tail.front;
        tail.front = temp.front ;
        temp.front.next = tail;
        map.remove(temp.key);
    }
}
class LinkNode{
    int key;
    int value;
    LinkNode front;
    LinkNode next;


    public LinkNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    List<Integer> list = new LinkedList();
}
