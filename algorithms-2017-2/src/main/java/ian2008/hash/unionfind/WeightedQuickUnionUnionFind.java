package ian2008.hash.unionfind;

import java.util.Arrays;
import java.util.Scanner;

/**
 * complexity: log N
 */
public class WeightedQuickUnionUnionFind extends UnionFind{

    int[] weight;

    public WeightedQuickUnionUnionFind(int n) {
        super(n);
        weight = new int[N];
        Arrays.setAll(weight,i->1);
    }

    public WeightedQuickUnionUnionFind(Scanner sc) {
        super(sc);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        count--;
        if (weight[pRoot] < weight[qRoot]){
            ids[pRoot]=qRoot;
            weight[qRoot]+=weight[pRoot];
        }else{
            ids[qRoot]=pRoot;
            weight[pRoot]+=weight[qRoot];
        }
    }

    @Override
    public int find(int p) {
        while( p != ids[p]) p = ids[p];
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return 0;
    }
}
