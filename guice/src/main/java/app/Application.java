package app;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application {
    public static void main(String[] args) {
     Injector injector = Guice.createInjector(new AppModule());

     TransactionLog log = injector.getInstance(TransactionLog.class);
     log.log("hello world");

    }
}
