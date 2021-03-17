package y2020;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IndexPQ<Item extends Comparable> {

    int size;
    Item[] items;
    int[] clientIndexToItemsIndex;
    int[] itemIndexToClientIndex;

    public IndexPQ(){
        items = (Item[])new Comparable[10];
        clientIndexToItemsIndex = new int[10];
        itemIndexToClientIndex = new int[10];
    }

    public void insert(Item item, int withIndex){
        int position = ++size;
        items[position] = item;
        clientIndexToItemsIndex[withIndex] = position;
        itemIndexToClientIndex[position] = withIndex;
        swim(position);
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            swap(k/2, k);
        }
    }

    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i, int j){
        Item tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;

        int tmpItemIndex = itemIndexToClientIndex[i];
        itemIndexToClientIndex[i] = itemIndexToClientIndex[j];
        itemIndexToClientIndex[j] = tmpItemIndex;

        clientIndexToItemsIndex[itemIndexToClientIndex[i]] = i;
        clientIndexToItemsIndex[itemIndexToClientIndex[j]] = j;

    }

    @Test
    public void t1(){
        IndexPQ<String> pq = new IndexPQ<>();

        pq.insert("A", 1);
        pq.insert("V", 2);
        pq.insert("X", 3);

        assertTrue(pq.itemIndexToClientIndex[1] == 3);
        assertTrue(pq.clientIndexToItemsIndex[3] == 1);

        assertTrue(pq.itemIndexToClientIndex[2] == 1);
        assertTrue(pq.clientIndexToItemsIndex[1] == 2);

        assertTrue(pq.itemIndexToClientIndex[3] == 2);
        assertTrue(pq.clientIndexToItemsIndex[2] == 3);
    }

}
