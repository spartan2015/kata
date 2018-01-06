package rank.datastructures.linkedlists;

/**
 * Created on 12/5/2017.
 */
public class CompareTwoLinkedLists {

    int CompareLists(Node headA, Node headB) {

        while(true){
            if (headA == null && headB == null){
                break;
            }else if ((headA == null && headB!=null) | (headB == null && headA!=null) ){
                return 0;
            }else{
                if (headA.data != headB.data){
                    return 0;
                }
            }
            headA = headA.next;
            headB = headB.next;
        }

        return 1;
    }

}
