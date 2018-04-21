import java.util.Stack;

public class AddTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> lst1=new Stack<Integer>();
        Stack<Integer>lst2=new Stack<Integer>();
        while(l1!=null){
            lst1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            lst2.push(l2.val);
            l2=l2.next;
        }
        int sum=0;
        ListNode node=new ListNode(0);
        while(!lst1.isEmpty() || !lst2.isEmpty()){
            if(!lst1.isEmpty()) sum+=lst1.pop();
            if(!lst2.isEmpty()) sum+=lst2.pop();

            node.val=sum%10;
            ListNode head=new ListNode(sum/10); // since we are adding to the left,the new node will always be the head
            head.next=node;
            node=head;
            sum/=10;
        }
        return node.val==0? node.next:node; // to take into account the overflow
    }
}
