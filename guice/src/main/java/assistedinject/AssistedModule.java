package assistedinject;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * Created on 8/21/2017.
 */
public class AssistedModule extends AbstractModule {
    protected void configure() {
        install(new FactoryModuleBuilder().implement(IPerson.class,Person.class).build(PersonFactory.class));
    }
}
