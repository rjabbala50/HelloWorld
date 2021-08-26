import com.sun.source.tree.Tree;

import java.util.Stack;

public class deleteaNode {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode()  {};
      ListNode(int x) { val = x; }
    }

    public static void deleteNode(ListNode node) {
       node.val = node.next.val ;
       node.next = node.next.next ;
    }

    public static ListNode reverse(ListNode head) {
        Stack st = new Stack() ;
        while (head != null) {
            st.push(head) ;
            head = head.next ;
        }
        ListNode newlist = new ListNode( );
        head = newlist ;
         while(!st.isEmpty()) {
           ListNode temp = (ListNode)st.pop() ;
           newlist.val = temp.val ;
           newlist.next = new ListNode();
           newlist = newlist.next ;
        }
        newlist.next = null ;
         return head ;
    }

    public static void printList(ListNode list) {
        while(list != null) {
            System.out.println("list.val = " + list.val);
            list = list.next ;
        }
    }

    public static void main(String[] args) {

        ListNode ln = new ListNode(4) ;
        ln.next = new ListNode(5) ;
        ln.next.next = new ListNode(1) ;
        ln.next.next.next = new ListNode(9)  ;
        ln.next.next.next.next = null ;
        printList(ln);
        //deleteNode(ln.next);
       ListNode newlist =  reverse(ln) ;
        printList(newlist);
    }
}
