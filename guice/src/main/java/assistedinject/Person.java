package assistedinject;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * Created on 8/21/2017.
 */
public class Person implements IPerson{
    PersonService personService;

    @Inject
    public Person(PersonService personService, @Assisted("name") String name, @Assisted("id")  String id){

    }

    void save(){
        personService.save(this);
    }
}
