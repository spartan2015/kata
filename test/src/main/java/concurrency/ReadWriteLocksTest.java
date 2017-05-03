package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Battlestar on 2/3/2015.
 */
public class ReadWriteLocksTest {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    void m(){
        lock.readLock().lock();

        lock.readLock().unlock();

    }

}
