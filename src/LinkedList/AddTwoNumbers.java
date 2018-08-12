package LinkedList;

public class AddTwoNumbers {
    //No:167:AddTwoNumbers
    public ListNode addLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;

        int ten = 0;
        while(l1 != null && l2 != null){
            int temp =  l1.val + l2.val + ten;
            curt.next = new ListNode(temp % 10);
            ten = temp / 10;
            curt = curt.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int temp = l1.val + ten;
            curt.next = new ListNode(temp % 10);
            ten = temp / 10;
            curt = curt.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int temp = l2.val + ten;
            curt.next = new ListNode(temp % 10);
            ten = temp / 10;
            curt = curt.next;
            l2 = l2.next;
        }
        if(ten != 0){
            curt.next = new ListNode(ten);
        }
        return dummy.next;
    }
}
