package datastructures;

import org.junit.Test;
import sedgewick.StdOut;

import java.util.Iterator;

/**
 * Created by Battlestar on 2/9/2015.
 */
public class LinkedList<I> implements Iterable<I> {
    static class Node<I>{
        I value;
        Node next;
    }

    Node<I> first = null;

    @Test
    public void test(){
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 0; i < 100; i++){
            ll.push(i);
        }

        for(Integer i : ll){
            StdOut.print(i);
        }

        for(int i = 0; i < 100; i++){
            ll.pop();
        }
    }

    @Override
    public Iterator<I> iterator() {
        return new Iterator<I>(){
            Node<I> current = new Node();
            {current.next = first;}
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public I next() {
                current = current.next;
                return current.value;
            }
        };
    }

    public void push(I item){
        Node<I> node = new Node<>();
        node.value=item;
        if (first == null) first = node;
        else {node.next = first; first = node;};
    }

    public I pop(){
        if (first != null) {
            first.next = null;
            return first.value;
        }else{
            return null;
        }
    }

}
