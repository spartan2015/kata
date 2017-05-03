/*
 * ColorChoose.java
 *
 * Created on 28 septembrie 2007, 15:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servlets;


import java.util.Locale;
import javax.servlet.http.*;
import java.io.PrintWriter;
/**
 *
 * @author neo_qs7
 */
public class ColorChoose2 extends javax.servlet.http.HttpServlet{
    
    /** Creates a new instance of ColorChoose */
    public ColorChoose2() {
    }
    
    public void process(HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        
        try{
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setLocale(new Locale("english"));
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        
        out.println("<h1>Hello " + session.getAttribute("username") + "/" + session.getAttribute("password") + "</h1>");
        out.println("<p>You chosed this color: " + request.getParameter("color") + "</p>");
        
        }catch(Throwable t){System.out.println("Error: " + t.getMessage());}
    }
    
    public void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        process(request,response);
    }
    
    public void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        process(request,response);
    }
    
}
