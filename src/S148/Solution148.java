package S148;

import java.util.List;

public class Solution148 {
    private ListNode tmp = new ListNode(-1);
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode[] position = new ListNode[64];
        int maxIDX = -1;
        // 暂存下一个结点
        ListNode carryNode = head;
        while (carryNode!=null){
            ListNode curNode = carryNode;
            carryNode = carryNode.next;

            // 当前结点取出来就和其他没有关系了，断开连接
            curNode.next = null;

            int i =0;
            while (position[i]!=null){
                curNode = merge(curNode,position[i]);
                position[i] = null;
                i++;
            }
            position[i] = curNode;
            if (i>maxIDX) maxIDX = i;
        }
        ListNode mergeTmp = null;
        for(int i=0;i<=maxIDX;i++){
            if(position[i]!=null) {
                mergeTmp = merge(mergeTmp, position[i]);
            }
        }

        return mergeTmp;

    }

    private ListNode merge(ListNode l1, ListNode l2){
        tmp.next = null;
        ListNode p = tmp;
        while (l1!=null||l2!=null){
            if (l1==null){
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
            else if(l2==null){
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
            else {
                if(l1.val<l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                    p = p.next;
                }
                else {
                    p.next = l2;
                    l2 = l2.next;
                    p = p.next;
                }
            }
        }
        return tmp.next;

    }
}
