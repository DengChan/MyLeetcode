package S146;

import java.util.HashMap;

class HashListNode{
    HashListNode pre;
    HashListNode back;
    int key;
    int val;
}

class LRUCache {
    HashMap<Integer, HashListNode> HashList = new HashMap<>();
    // 保存容量
    private int capacity;
    // 已占据空间
    private int takeup;
    // 链表的头，不保存数据
    private HashListNode head;
    // 链表的尾
    private HashListNode tail;
    // 构造函数
    public LRUCache(int capacity) {
        // 初始化容量和已占据空间
        this.capacity = capacity;
        this.takeup = 0;
        // 初始化一个结点，不保存数据，仅用于头部索引
        HashListNode head = new HashListNode();
        head.pre = null;
        head.val = -9999999;

        HashListNode tail = new HashListNode();
        tail.pre = head;
        tail.back = null;

        head.back = tail;

        this.head = head;
        this.tail = tail;

    }

    public int get(int key) {
        // 如果有这个key
        if(HashList.containsKey(key)) {
            // 获得这个key对应的结点
            HashListNode node = HashList.get(key);
            // 获得该结点的值
            int res = node.val;
            insertToHead(node);
            return res;
        }
        else return -1;
    }

    public void put(int key, int value) {
        // 存在该键值，则插入
        if(HashList.containsKey(key)){
            HashListNode node = HashList.get(key);
            node.val = value;
            insertToHead(node);
        }
        else {
            // 如果超出了容量，则最后一个结点有数据，需要把这个数据从Hash表中删除
            if (takeup>=capacity){
                HashList.remove(tail.key);
            }

            // 否则更新takeup+1
            else takeup+=1;
            tail.val = value;
            tail.key = key;
            HashList.put(key,tail);
            insertToHead(tail);

            if(takeup < capacity) {
                HashListNode new_tail = new HashListNode();
                tail.back = new_tail;
                new_tail.pre = tail;
                tail = new_tail;
            }
        }
    }

    private void insertToHead(HashListNode node){
        // 获得前结点和后继结点
        HashListNode pre = node.pre;
        HashListNode next = node.back;
        // 如果前结点是头部，则不需要改变连边，如果前结点不是头部，则需要改动
        if(pre!=head){
            // 把前结点的后继改为自己的后继
            pre.back = next;
            // 如果后继不是Null 则把后继的前结点改为自己的前结点
            if(next!=null) next.pre = pre;

            // 维护尾结点，如果node是尾巴，则把前结点改为尾巴
            if(node == tail) tail = pre;

            // 把自己的后继改为链表第一个结点，头部的后继改为自己
            // 自己的前结点改为头部，第一个结点的前结点改为自己
            HashListNode first = head.back;
            head.back = node;
            node.back = first;
            node.pre = head;
            if (first!=null) first.pre =node;
        }
    }

}
