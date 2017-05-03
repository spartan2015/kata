/*
 * AddToCart.java
 *
 * Created on 02 octombrie 2007, 09:53
 */

package shoppingcart;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Owner
 * @version
 */
public class AddToCart extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
        
        
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart",cart);
        }
        
        cart.addItem(new Item(request.getParameter("productCode"),request.getParameter("description"),new Double(request.getParameter("price")), new Integer(request.getParameter("quantity")).intValue()));
       
        response.sendRedirect("DisplayShoppingCart.jsp");
                
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
