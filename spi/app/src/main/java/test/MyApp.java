package test;

import java.util.ServiceLoader;

public class MyApp {
    private static ServiceLoader<MyService> codecSetLoader
                = ServiceLoader.load(MyService.class);

    public static void main(String[] args) {
        MyService service = getService("someService");
        System.out.println(service);
    }

    public static MyService getService(String name) {
      for (MyService myServiceProvider : codecSetLoader) {
          MyService myService = myServiceProvider.getEncoder(name);
          if (myService != null)
              return myService;
      }
      return null;
  }
}
