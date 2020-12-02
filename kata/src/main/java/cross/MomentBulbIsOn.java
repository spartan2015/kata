package cross;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * find connected bulbs
 */
public  class MomentBulbIsOn {

    private int[] id;
    private int[] size;
    private int count;

    @Test
    public void t1(){
        assertEquals(3, new MomentBulbIsOn().solution(new int[]{2,1,3,5,4}));
    }

    public int solution(int[] momentBulbOn) {
        int on[] = new int[momentBulbOn.length];

        int allOn = 0;

        count = momentBulbOn.length;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
        size = new int[count];
        for (int i = 0; i < count; i++) {
            size[i] = 1;
        }

        for (int i = 0; i < momentBulbOn.length; i++) {
            int bulbIndex = momentBulbOn[i]-1;
            on[bulbIndex] = 1;
            for (int h = bulbIndex - 1; h >= 0; h--) {
                if (on[h] == 1) {
                    union(h, h + 1);
                } else {
                    break;
                }
            }

            for (int h = bulbIndex + 1; h < on.length; h++) {
                if (on[h] == 1) {
                    union(h, h - 1);
                } else {
                    break;
                }
            }

            if (connected(0, bulbIndex)) {
                allOn++;
            }
        }

        return allOn;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);

    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

}
