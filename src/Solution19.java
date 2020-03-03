public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_head = new ListNode(-1);
        new_head.next = head;
        ListNode p = new_head;
        ListNode q = new_head;
        while (n>0){
            q = q.next;
            n--;
        }

        while (q.next!=null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return new_head.next;
    }
}
