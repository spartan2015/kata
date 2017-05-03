package session;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

public class session extends HttpServlet {
    //private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    public HttpServletRequest request;
    public HttpServletResponse response;
    public PrintWriter out;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException 
    {
        this.request = request;
        this.response = response;                        
        this.out = response.getWriter();
        
        
        // set a cookie
        Cookie nc = new Cookie("javaCookie","valueforJavaCookie");
        //nc.setDomain("localhost");
        //nc.setPath("/");
        nc.setComment("comment");
        nc.setMaxAge(24*60*60); // paramater int: seconds until deletion: 0 deletion; 24*60*60 = 1 day
        //nc.setSecure();
        //nc.setValue();
        //nc.setVersion();
        
        response.addCookie(nc);
        
        
        
        out.println("<html>");
        out.println("<head><title>session</title></head>");
        out.println("<body>");
        
        
        out.println("<p>Session start 3.</p>");
        
        
        
       
       
        //request.getAttribute();
        
        o("Auth Type: "+ request.getAuthType());      
        out.println("Character encoding: "+request.getCharacterEncoding());
        o("Class: " + request.getClass());
        o("Content length: "+request.getContentLength());
        o("Content type: "+request.getContentType());
        
        //o("Date header: "+request.getDateHeader("String header"));  // returns long
        
        o("Method: "+request.getMethod());
        o("PathInfo: "+request.getPathInfo());
        //request.getHeader()
        //request.getHeaderNames()
        //request.getParameter()
        //request.getParameterNames() Enumeration
        //request.getParameterValues() String[]
        o("Path translated: " + request.getPathTranslated());
        o("Request Protocol: " + request.getProtocol());
        o("Query String: " + request.getQueryString());
        o("getRealPath: " + request.getRealPath("tt/"));
        //request.getReader() // Buffered Reader
        
        o("RemoteAddr: "+request.getRemoteAddr());
        o("RemoteHost: "+request.getRemoteHost());
        o("RemoteUser: "+request.getRemoteUser());
        o("RequestedSeesionId: "+request.getRequestedSessionId());
        o("RequestURI: "+request.getRequestURI());
        o("getScheme: "+request.getScheme());
        o("ServerName: "+request.getServerName());
        o("ServerPort: "+request.getServerPort());
        o("ServerPath: "+request.getServletPath());
        
        
        HttpSession sess = request.getSession(true); // HTTPSession
        if (sess.isNew()==true)
            o("New Session");
        else
            o("Old session");
        
        sess.putValue("sessionVar1","value1");
        sess.putValue("sessionVa2","value2");
        sess.removeValue("sessionVar2");        
        
        o("Session class:  "+sess.getClass());
        
        SimpleDateFormat ax = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        
        
        //new SimpleDateFormat.format(,new StringBuffer(),0)))
        o("Session creation time "+ ax.format(new Date(sess.getCreationTime())));
        o("Session id:  " +sess.getId());
        
        
        o("Session last access time:  "+ ax.format(new Date(sess.getLastAccessedTime())));
        HttpSessionContext sessc = sess.getSessionContext(); // HttpSessionContext
        
        //o((String)sess.getValue("sessionVar1")); //Object
        String sc[] = sess.getValueNames(); //String[]
        for(int sec = 0 ; sec < sc.length; sec ++) {
            o("Session var no: " + sec + ", name=" +sc[sec]+ ", value=" + sess.getValue(sc[sec]));
        }
        sess.hashCode();
        
        
        
        
        
        
        printCookies();
        printHeaders();
        printParameters();
        
        
        
        
        
        
        
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException 
    {
        doGet(request,response);
    }
    
    public void o(String s){
        out.println(s);
    }
    
    public void printCookies(){
        Cookie c[] = request.getCookies();
        for(int y = 0 ; y < c.length; y++) {
            o("\nCookie number: " + y);
            o("Name: " + c[y].getName());
            o("Value: " + c[y].getValue());
            o("Class: " + c[y].getClass());
            o("Comment: " + c[y].getComment());
            o("Domain: " + c[y].getDomain());
            o("MaxAge: " + c[y].getMaxAge());
            o("Path: " + c[y].getPath());
            o("Secure: " + c[y].getSecure());
            o("Version: " + c[y].getVersion());
            o("Hashcode: " + c[y].hashCode());            
        }
    }
    
    
    public void printParameters() 
    {
        // print parameters
        
         /*
         try{
         
         String firstName = request.getParameter("firstname");
         String lastName = request.getParameter("lastname");
        
        
          if (firstName != null || lastName != null) {
          
                      out.println("Parameters: ");         
                      out.println("First Name:");
                      out.println(" = " + firstName + "<br>");
                      out.println("Last Name:");
                      out.println(" = " + lastName);
                  } else {
                      out.println("No Parameters, Please enter some");
                  }

         }catch(Throwable ex){ out.println("Error: " + ex.getMessage());}
         */
         
         Enumeration values = request.getParameterNames();
         while(values.hasMoreElements()) 
         {
              String name = (String)values.nextElement();
              String value = request.getParameterValues(name)[0];
              if(name.compareTo("submit") != 0) 
                  out.println("\n" + name + ": " + value);
         }
                     

         // !print parameters
        
    }
    
    
    
    public void printHeaders(){
        
        // print Headers
        Enumeration e = request.getHeaderNames();
        while(e.hasMoreElements())
        {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            out.println("\n" + name + ":" + value);
        }    
        //out.println(request.getHeader("GET"));
        //! print Headers
        
    }
    
}
