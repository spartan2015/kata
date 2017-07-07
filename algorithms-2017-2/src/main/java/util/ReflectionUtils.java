package util;

import java.lang.reflect.Field;

/**
 * Created on 7/7/2017.
 */
public class ReflectionUtils {
    public static <T> T getFieldValue(Object target, String fieldName) {
        String[] fields = fieldName.split("\\.");
        for(String field : fields) {
            Field reader = null;
            try {
                reader = target.getClass().getDeclaredField(field);
                reader.setAccessible(true);
                target = reader.get(target);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (T)target;
    }
}
