package servlets;
/*
 * logger.java
 *
 * Created on 26 septembrie 2007, 11:43
 */

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;
/**
 *
 * @author neo_qs7
 * @version
 */
public class logger extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, FileNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        Logger logger = Logger.getLogger("examples.logger");
        logger.info("In the doGet method of Log4JServlet!");        
        logger.fatal("fatal error here",new Throwable("error in stack tree"));
        logger.error("error level");
        logger.debug("debug level");
        logger.warn("warn level");
        
        
        
        System.setOut(new PrintStream(new FileOutputStream("c:\\log.file")));
        System.out.println("out there 1");
        System.out.println("out there 2");
        System.out.println("out there 3");
        
        
        out.println("Done");
        
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
