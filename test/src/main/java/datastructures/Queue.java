package datastructures;

import org.junit.Test;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Battlestar on 2/10/2015.
 */
public class Queue<T> implements Iterable {

    @Test
    public void t(){
        Queue<Integer> q = new Queue<>();
        IntStream.rangeClosed(0,100).boxed().forEach(q::enqueue);

        q.forEach(System.out::println);

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public T next() {
                return dequeue();
            }
        };
    }

    static class Node<T>{
        T value;
        Node next;
    }

    Node first;
    Node last;

    public void enqueue(T value){
        Node node = new Node();
        node.value = value;
        if (first == null) first = node;
        if (last != null) last.next = node;
        last = node;
    }

    public T dequeue(){
        Node<T> item = first;
        if (item == null) return null;
        first = first.next;
        item.next = null;
        return item.value;
    }


}
