public class addTwo {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = l1;
        ListNode p = l1;
        while (l1!=null&&l2!=null){
            int sum = l1.val + l2.val + jinwei;
            jinwei = sum / 10;
            sum = sum%10;
            p.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            if(p.next==null&&(l1!=null || l2!=null||(jinwei!=0))){
                p.next = new ListNode(-1);
            }
            p = p.next;
        }

        ListNode l;
        if (l1!=null) l = l1;
        else l = l2;
        while (l!=null){
            if(jinwei==0){
                p.val = l.val;
                p.next = l.next;
                break;
            }

            int sum = jinwei + l.val;
            jinwei = sum / 10;
            p.val = sum % 10;

            l = l.next;
            if(p.next == null && l!=null) p.next = new ListNode(-1);
            p = p.next;
        }
        if (jinwei!=0) p.val = jinwei;

        return head;
    }

    public static void main(String[] args){

    }
}
