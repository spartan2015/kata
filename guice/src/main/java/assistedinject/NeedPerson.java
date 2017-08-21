package assistedinject;

import javax.inject.Inject;

/**
 * Created on 8/21/2017.
 */
public class NeedPerson {
    @Inject
    PersonFactory personFactory;

    void usePersonFactory(){
        Person person = personFactory.create("John","1");
    }
}
