package rank.datastructures.linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created on 12/8/2017.
 */
public class CycleDetect {

    boolean hasCycle(Node head) {
        if (head == null) return false;
        Node a = head;
        Node b = head;
        while( (a = a.next)!= null && (b.next != null && (b = b.next.next)!=null)){
            if (a == b){
                return true;
            }
        }
        return false;
    }

    @Test
    public void c1(){
        Node head = Node.build(1,2);
        head.next.next=head;
        assertTrue(hasCycle(head));
    }

    @Test
    public void c2(){
        Node head = Node.build(1,2);
        assertFalse(hasCycle(head));
    }
}
