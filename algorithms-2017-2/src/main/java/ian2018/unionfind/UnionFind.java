package ian2018.unionfind;

import java.util.Scanner;

/**
 * Create components based on connecting N nodes;
 *
 * implementations must:
 * - Define a data structure to represent the known connections
 * - Develop efficient union(), find(), connected(), and count() implementations that are based on that data structure
 */
public abstract class UnionFind {
    /**
     * no of nodes
     */
    int N;
    /**
     * no of components
     */
    int count;

    int[] ids;

    public UnionFind(int n) {
        this.N = n;
        ids = new int[N];
        for(int i =0; i < N; i++){
            ids[i]=i; // initially each node is in its own component
        }
        count = N; // that is the initial no of components
    }

    public UnionFind(Scanner sc) {
        this(sc.nextInt());
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            union(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
        }
    }

    /**
     * merges two component (the component that contains p, and the component that contains q)
     *
     * @param p
     * @param q
     */
    public abstract void union(int p, int q);

    /**
     *
     *
     * @param p
     * @return component identifier for node p (yeah he must be part of a component, even if of one)
     */
    public abstract int find(int p);

    public abstract boolean connected(int p, int q);

    /**
     * no of components
     *
     * @return
     */
    public abstract int count();

}
