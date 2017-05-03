/*
 * servlet1.java
 *
 * Created on 19 septembrie 2007, 12:53
 */

package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author neo_qs7
 * @version
 */
public class servlet1 extends HttpServlet {
    
    public java.util.Enumeration a;
    public java.util.Enumeration b;
    
    public void init(ServletConfig c) throws ServletException{
        super.init(c);

        //public java.util.Enumeration getInitParameterNames();
        //public String getInitParameter(String name);
        try{
        
        this.a = c.getInitParameterNames();
        
        this.b = c.getServletContext().getInitParameterNames();
                
        /*
          while (a.hasMoreElements()){                
                String s = (String)a.nextElement();
                System.out.println("InitParameter name: " + s + ", InitValue: " + this.getServletContext().getInitParameter(s));
            }         
         */
        } catch(Throwable t){ System.err.println(t);}
    }
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here*/
                
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet servlet1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet servlet1 at " + request.getContextPath () + "</h1>");
        out.println("<h1>Hello World !</h1>");
        
         
        try{
        
        if (b != null)
        {    
            out.println("<h1>IN B</h1>");
            
            while (b.hasMoreElements()){
                String s = (String)b.nextElement();
                out.println("InitParameter name: " + s + ", InitValue: " + this.getServletContext().getInitParameter(s));
            }
                            
        }
        
        
         if (a != null)
         {
           out.println("<h1>IN A</h1>");
         
            while (a.hasMoreElements()){                
                String s = (String)a.nextElement();
                System.out.println("InitParameter name: " + s + ", InitValue: " + this.getServletContext().getInitParameter(s));
            }
         }
        /*
        if (a != null)
        {    
            out.println("<h1>IN A</h1>");
            
            while (a.hasMoreElements())
                out.println((String)a.nextElement());
        }
        else
               out.println("<h1>NULL</h1>");
        */
         
        } catch(Throwable t){ System.err.println(t);}
       
        
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
