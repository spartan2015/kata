package assistedinject;

import com.google.inject.assistedinject.Assisted;

/**
 * Created on 8/21/2017.
 */
public interface PersonFactory {
    Person create(@Assisted("name") String name, @Assisted("id")  String id);
}
