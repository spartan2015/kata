import assistedinject.AssistedModule;
import assistedinject.PersonFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created on 8/21/2017.
 */
public class TestAssistedInjection {

    protected Injector injector = Guice.createInjector(new AssistedModule());

    @Inject
    PersonFactory personFactory;

    @Before
    public void setup () {
        injector.injectMembers(this);

    }

    @Test
    public void case1(){
        assertNotNull(personFactory);
    }

}
