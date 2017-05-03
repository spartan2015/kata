package algos;

import java.util.concurrent.TimeUnit;

/**
 * Created by Battlestar on 2/23/2015.
 */
public class Utils {

    public static void cron(String taskName, Runnable runnable){
        long start = System.nanoTime();
        runnable.run();
        long time = System.nanoTime()-start;
        long milis =  TimeUnit.NANOSECONDS.toMillis(time);
        String output = ( milis> 0 ? milis + "ms" : time + "ns");
        System.out.println(taskName+" duration: " + output);
    }
}
