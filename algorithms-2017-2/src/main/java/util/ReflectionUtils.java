package util;

import java.lang.reflect.Field;

/**
 * Created on 7/7/2017.
 */
public class ReflectionUtils {
	
	
public static <T> T getFieldValue(Object target, String fieldName)
  {
    if (target == null) return null;
    String[] fields = fieldName.split("\\.");
    for ( String field : fields )
    {
      Field reader = null;
      try
      {
        Class<?> aClass = target.getClass();
        while ( aClass != null )
        {
          try
          {
            reader = aClass.getDeclaredField(field);
          }
          catch ( NoSuchFieldException e )
          {
            //ignore
          }
          if ( reader != null )
          {
            break;
          }
          aClass = aClass.getSuperclass();
        }
        if (reader!=null )
        {
          reader.setAccessible(true);
          target = reader.get(target);
        }
      }
      catch ( IllegalAccessException e )
      {
        e.printStackTrace();
      }
    }
    return (T) target;
  }
	
	public static <T> T setFieldValue(Object target, String fieldName, Object value) {
    String[] fields = fieldName.split("\\.");
    for(String field : fields) {
      Field reader = null;
      Class clazz = target.getClass();      
      while(clazz!=null){
      try {
        reader = clazz.getDeclaredField(field);
        reader.setAccessible(true);
        reader.set(target,value);
        return (T)target;
      } catch (NoSuchFieldException e)
      {
        e.printStackTrace();
      }
      catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      clazz = clazz.getSuperclass();
    }
    return (T)target;
  }
}
