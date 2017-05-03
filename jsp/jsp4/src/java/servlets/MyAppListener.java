   package servlets;

  import java.io.*;
  import javax.servlet.*;
  import javax.servlet.http.*;

  public class MyAppListener  implements ServletContextListener {
      public void contextInitialized(ServletContextEvent event) {
          ServletContext context = event.getServletContext();
          context.log("***ShowLifecycles - Created the servlet context");
      }

      public void contextDestroyed(ServletContextEvent event) {
          ServletContext context = event.getServletContext();
          context.log("***ShowLifecycles - Destroyed the servlet context");
      }
  }
