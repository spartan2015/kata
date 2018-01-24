package ian2008.hash.unionfind;

import java.util.Scanner;

/**
 * complexity: N^2
 */
public class QuickUnionUnionFind extends UnionFind {
    public QuickUnionUnionFind(int n) {
        super(n);
    }

    public QuickUnionUnionFind(Scanner sc) {
        super(sc);
    }

    @Override
    public void union(int p, int q) {
        int pRootId = find(p);
        int qRootId = find(q);
        if (pRootId == qRootId) return;
        count--;
        ids[pRootId] = qRootId;
    }

    @Override
    public int find(int p) {
        int pRootId = p;
        while( (pRootId =ids[pRootId]) != p);
        return pRootId;
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
