package algos;

import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.TestCase.*;

/**
 * Created by vasilei on 3/16/2015.
 */
public class ConnectivityTest {

    @Test
    public void t(){
        Network n = new Network1(3) ;

        n.union(0,1);
        assertTrue(n.connected(0,1));
        assertFalse(n.connected(1, 2));
    }

}


class Network1 implements Network{

    int[] siteComponents;
    int componentsCount;

    Network1(int sites){
        componentsCount = sites;
        siteComponents = new int[sites];
        IntStream.rangeClosed(0,sites).forEach((i)->siteComponents[i]=i);
    }

    @Override
    public boolean connected(int p, int q) {
        return siteComponents[p] == siteComponents[q];
    }

    @Override
    public void union(int p, int q) {
        int componentIdForQ = find(q);
        int componentIdForP = find(p);
        if (componentIdForQ!=componentIdForP) {
            IntStream.rangeClosed(0,siteComponents.length-1).forEach(i->{
                if (siteComponents[i] == componentIdForQ){
                    siteComponents[i] = componentIdForP;
                }
            });
            componentsCount--;
        }
    }

    @Override
    public int find(int p) {
        return siteComponents[p];
    }


}


class Network2 implements Network{

    int[] siteComponents;
    int componentsCount;

    Network2(int sites){
        componentsCount = sites;
        siteComponents = new int[sites];
        IntStream.rangeClosed(0,sites).forEach((i)->siteComponents[i]=i);
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int componentIdForQ = find(q);
        int componentIdForP = find(p);

        if (componentIdForQ!=componentIdForP){
           siteComponents[componentIdForP] = componentIdForQ;
           componentsCount--;
       }
    }

    @Override
    public int find(int p) {
       while(p != siteComponents[p]) p = siteComponents[p];
        return p;
    }
}

class Network3 implements Network{

    int[] siteComponents;
    int componentsCount;
    int[] sizes;

    Network3(int sites){
        componentsCount = sites;
        siteComponents = new int[sites];
        IntStream.rangeClosed(0,sites).forEach((i)->siteComponents[i]=i);
        sizes = new int[sites];
        IntStream.rangeClosed(0,sites).forEach((i)->sizes[i]=1);

    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int componentIdForQ = find(q);
        int componentIdForP = find(p);

        if (componentIdForQ == componentIdForP) return;

        if (sizes[componentIdForP]<sizes[componentIdForQ]){
            siteComponents[componentIdForP] = componentIdForQ;
            sizes[componentIdForQ]+=sizes[componentIdForP];
        }else{
            siteComponents[componentIdForQ] = componentIdForP;
            sizes[componentIdForP]+=sizes[componentIdForQ];
        }

        componentsCount--;
    }

    @Override
    public int find(int p) {
        while(p != siteComponents[p]) p = siteComponents[p];
        return p;
    }
}

interface Network{
    boolean connected(int p, int q);
    void union(int p, int q);
    int find(int p);

}