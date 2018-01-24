package ian2008.hash.unionfind;


import java.util.Scanner;

/**
 * complexity N^2
 */
public class QuickFindUnionFind extends UnionFind {

    public QuickFindUnionFind(int n) {
        super(n);
    }

    public QuickFindUnionFind(Scanner sc) {
        super(sc);
    }

    @Override
    public void union(int p, int q) {
        // find change all ids[p] to ide
        int componentOfP = find(p);
        int componentOfQ = find(q);
        if (componentOfP == componentOfQ) return;

        for(int i = 0; i < N; i++){
            if (ids[i]== componentOfQ){
                ids[i] = componentOfP;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return ids[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return ids[p]==ids[q];
    }

    @Override
    public int count() {
        return 0;
    }
}
