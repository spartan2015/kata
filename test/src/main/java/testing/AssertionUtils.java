package testing;

/**
 * Created by Battlestar on 2/8/2015.
 */
public class AssertionUtils {
    public static void assertException(Runnable task, Class<?> clazz){
        try{
            task.run();
            throw new AssertionError(String.format("expected exception of type %s",clazz.getSimpleName()));
        }catch(Exception ex){
            if (!ex.getClass().isAssignableFrom(clazz)){
                new AssertionError(String.format("expected exception of type %s but found exception of type %s",clazz.getCanonicalName(), ex.getClass().getCanonicalName()));
            }
        }
    }
}
