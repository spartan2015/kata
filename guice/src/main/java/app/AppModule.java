package app;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class AppModule extends AbstractModule {
    protected void configure() {

        bind(TransactionLog.class).to(DbTransactionLog.class).in(Singleton.class);

    }
}
