package rank.datastructures.linkedlists;

import static rank.datastructures.linkedlists.Node.build;

/**
 * challenges/merge-two-sorted-linked-lists/problem
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        new MergeTwoSortedLinkedLists().mergeLists(build(2,4,6), build(1,3));
    }

    Node mergeLists(Node headA, Node headB) {
       if (headA == null) return headB;
       if (headB == null) return headA;

       if (headA.data < headB.data){
           Node tmp = headB;
           headB = headA;
           headA = tmp;
       }

        Node current = headB;
        while( headA!=null){
            while(current.next!=null && current.next.data < headA.data) {
                current = current.next;
            }
            Node tmp = current.next;
            current.next = headA;
            headA = headA.next;
            current.next.next=tmp;
        }

        return headB;
    }
}
