package algos;

import org.junit.Test;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class HeapTest {

    @Test
    public void test(){
        Heap<Integer> heap = new Heap<Integer>();
        heap.add(1);
        heap.add(2);

        heap.add(4);
        heap.add(5);

        heap.add(3);
       Integer element = null;
       while( (element = heap.poll())!=null){
           System.out.println(element);
       }

    }

    static class Heap<E extends Comparable<E>> {
        int count = 0;
        Object[] collection = new Object[100];

        void add(E element) {
            if (count >= collection.length) {
                throw new RuntimeException("no space");
            }
            collection[count++] = element;
            moveUp(count);
        }

        E poll(){
            if (count  == 0){
                return null;
            }
           E head = (E)collection[0];
           collection[0] = collection[--count];
           moveDown(1);
           return head;
        }

        void moveDown(int k){
            if (exists(k)){
                // which element is larger - left or right ?
                int larger = left(k);
                if (exists(right(k))){
                    if (item(right(k)).compareTo(item(larger)) > 0){
                        larger = right(k);
                    }
                }

                if (item(larger)!= null && item(k).compareTo(item(larger)) < 0){
                    swap(larger-1,k-1);
                    moveDown(larger);
                }
            }
        }

        E item(int k){
            return (E)collection[k-1];
        }

        void moveUp(int k){
           if (k==1) return;
           if (item(parent(k)).compareTo(item(k)) < 0){
               swap(parent(k)-1,k-1);
               moveUp(parent(k));
           }

        }

        int parent(int k){
            if (k <= 1) return 0;
            else{
                if (k%2==0){
                    return k/2;
                }else{
                    return (k-1)/2;
                }
            }
        }

        int left(int k) {
            return 2 * k;
        }

        int right(int k) {
            return 2 * k + 1;
        }

        boolean exists(int k) {
            return k > 0 && k <= count;
        }

        void swap(int i, int j) {
                E temp = (E) collection[i];
                collection[i] = collection[j];
                collection[j] = temp;

        }
    }
}
