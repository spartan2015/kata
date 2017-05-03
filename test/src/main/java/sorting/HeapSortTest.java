package sorting;

import org.junit.Test;

/**
 * Created by Battlestar on 1/12/2015.
 */
public class HeapSortTest {
    @Test
    public void test(){

        Heap<Integer> heap = new Heap<>();

        HeapNode<Integer> node = new HeapNode<>();
        node.value = 1;

        heap.addNode(node);

        node = new HeapNode<>();
        node.value = 2;

        heap.addNode(node);

        node = new HeapNode<>();
        node.value = 3;

        heap.addNode(node);

        node = new HeapNode<>();
        node.value = 4;

        heap.addNode(node);
        System.out.println("end");

    }

}


