package patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Battlestar on 2/11/2015.
 */
public class FactoryTest {

    public Object createObject(String name){
        switch(name){
            case "string": return new String();
            case "number": return new Integer(0);
        }
        throw new UnsupportedOperationException("");
    }

    // or with lambdas
    Map<String, Supplier<Object>> factory = new HashMap<>();
    {
        factory.put("string", String::new);
        factory.put("map", HashMap::new);
    }

    public Object createObjectWithLambda(String name){
        Supplier<Object> supplier = factory.get(name);
        if (supplier != null) return supplier.get();
        else throw new UnsupportedOperationException("");
    }

    public interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
    }


}
